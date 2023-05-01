package others;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem143 {
    final int MAX = 10000;
    int n;
    int[][] arr;
    /**
     * 폭탄 해체
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = n - 1;
        for (int t = MAX; t >= 1; t--) {
            while (idx >= 0 && arr[idx][1] >= t) {
                pq.add(-arr[idx][0]);
                idx--;
            }
            if (!pq.isEmpty())
                sum += -pq.poll();
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
