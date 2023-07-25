package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2891 {
    int n, s, r;

    /**
     * 카약과 강풍
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]--;
        }
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[num] == 0) arr[num]++;
            else pq.add(num);
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (num > 1 && arr[num - 1] == 0) arr[num - 1]++;
            else if (num < n && arr[num + 1] == 0) arr[num + 1]++;
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
