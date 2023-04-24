package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1911 {
    int n, l;
    /**
     * 흙길 보수하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, e};
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int len = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {

            idx = Math.max(idx, arr[i][0]);
            if (arr[i][1] <= idx)
                continue;
            int cnt = (int) Math.ceil((double) (arr[i][1] - idx)/l);
            idx += cnt * l;
            len += cnt;
        }
        bw.write(len + "\n");
        bw.flush();
        bw.close();
    }
}
