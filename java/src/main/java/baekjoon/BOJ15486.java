package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ15486 {
    final int MAX = 1_500_000;
    int n;
    int[] dp = new int[MAX + 1];
    Consult[] arr;
    /**
     * 퇴사 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new Consult[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            int t = Integer.parseInt(line[0]);
            int p = Integer.parseInt(line[1]);
            arr[i] = new Consult(t, p);
        }
        for (int i = n; i >= 1; i--) {
            if (i + arr[i].time - 1 > n)
                dp[i] = dp[i + 1];
            else
                dp[i] = Math.max(dp[i + 1], dp[i + arr[i].time] + arr[i].pay);
        }
        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    class Consult {
        int time;
        int pay;

        public Consult(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }
    }
}
