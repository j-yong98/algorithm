package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
    int n;
    int[][] arr;

    /**
     * 강의실 배정
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, e};
        }
        Arrays.sort(arr, (a, b)->a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= arr[i][0]) pq.poll();
            pq.add(arr[i][1]);
        }
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
    }
}
