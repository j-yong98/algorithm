package others;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem152 {
    int T;
    int n, m;
    int ans;
    int[] arr;
    int[] snack;
    /**
     * 한빈이와 Spot Mart
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            snack = new int[n];
            arr = new int[2];
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                snack[i] = Integer.parseInt(st.nextToken());
            f(0, 0);
            ans = ans == 0 ? -1 : ans;
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }

    private void f(int l, int visited) {
        if (l == 2) {
            int sum = Arrays.stream(arr).sum();
            if (sum > m)
                return ;
            ans = Math.max(ans, sum);
            return ;
        }
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0) {
                arr[l] = snack[i];
                f(l + 1, visited | (1 << i));
            }
        }
    }
}
