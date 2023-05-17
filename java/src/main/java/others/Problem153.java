package others;

import java.io.*;

public class Problem153 {
    int T = 10;
    /**
     * View
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(line[i]);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = i - 2; j <= i + 2; j++) {
                    if (j < 0 || j >= n) continue;
                    if (j == i) continue;
                    if (max < arr[j])
                        max = arr[j];
                }
                int res = arr[i] - max;
                ans += res < 0 ? 0 : res;
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
