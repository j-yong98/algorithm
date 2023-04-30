package others;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem139 {
    int T;

    /**
     * 군주제와 공화제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<int[]> info = new ArrayList<>();
            info.add(new int[]{0, 0, 0});
            String[] res = new String[n + 1];
            int[] influence = new int[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                info.add(new int[]{x, y, s});
            }
            for (int i = 1; i <= n; i++) {
                int[] a = info.get(i);
                double power = -1.0;
                int idx = 0;
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    int[] b = info.get(j);
                    double p = b[2] / (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
                    if (a[2] < p) {
                        cnt++;
                        if (power < p) {
                            power = p;
                            idx = j;
                            res[i] = "K";
                        }
                        else if (power == p)
                            res[i] = "D";
                    }
                }
                if (cnt > 0) {
                    if (res[i] != "D")
                        res[i] = String.valueOf(idx);
                }
                else
                    res[i] = "K";
            }
            bw.write("#" + t + " ");
            for (int i = 1; i <= n; i++) {
                res[i] = findUnion(res, i, 0);
                bw.write(res[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private String findUnion(String[] arr, int idx, int cnt) {
        if (arr[idx].equals("K") || arr[idx].equals("D")) {
            if (cnt > 0)
                return String.valueOf(idx);
            return arr[idx];
        }
        return findUnion(arr, Integer.parseInt(arr[idx]), cnt + 1);
    }
}
