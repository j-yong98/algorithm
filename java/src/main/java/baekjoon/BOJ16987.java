package baekjoon;

import java.io.*;

public class BOJ16987 {
    int n;
    int[] s;
    int[] w;
    int ans = 0;
    boolean isFinish = false;
    /**
     * 계란으로 계란 치기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            s[i] = Integer.parseInt(line[0]);
            w[i] = Integer.parseInt(line[1]);
        }
        crack(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void crack(int l, int cnt) {
        if (isFinish)
            return ;
        if (cnt == n) {
            ans = n;
            isFinish = true;
            return ;
        }
        if (l == n) {
            ans = Math.max(ans, cnt);
            return;
        }
        if (s[l] <= 0 || cnt == n - 1) {
            crack(l + 1, cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i == l || s[i] <= 0)
                continue;
            int c = 0;
            s[i] -= w[l];
            s[l] -= w[i];
            if (s[i] <= 0) c++;
            if (s[l] <= 0) c++;
            crack(l + 1, cnt + c);
            s[i] += w[l];
            s[l] += w[i];
        }
    }
}
