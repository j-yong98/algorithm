package others;

import java.io.*;
import java.util.*;

public class Problem135 {
    int n;
    int[] arr;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long ans = 0;

    /**
     * 숫자 합치기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pq.add(Integer.valueOf(st.nextToken()));
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            ans += a + b;
            pq.add(a + b);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
