package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ20207 {
    int N;
    int[] arr;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    /**
     * 달력
     */
    public void soltuion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.max(a, b));
            pq.add(new int[]{a, b});
        }
        arr = new int[max + 1];
        while (!pq.isEmpty()) {
            int[] day = pq.poll();
            for (int s = day[0]; s <= day[1]; s++)
                arr[s]++;
        }
        int ans = 0;
        int height = 0;
        int length = 0;
        for (int i = 1; i <= max; i++) {
            if (arr[i] == 0) {
                ans += height * length;
                height = 0;
                length = 0;
            }
            else {
                height = Math.max(arr[i], height);
                length++;
            }
        }
        ans += height * length;
        System.out.println(ans);
    }
}
