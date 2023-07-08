package baekjoon;

import java.io.*;

public class BOJ20437 {
    int T;
    String W;
    int K;
    int[] ans;
    int[] cnt;
    /**
     * 문자열 게임 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            ans = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            cnt = new int[26];
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            for (int i = 0; i < W.length(); i++)
                cnt[W.charAt(i) - 'a']++;
            for (int i = 0; i < W.length(); i++) {
                if (cnt[W.charAt(i) - 'a'] < K) continue;
                int k = 0;
                for (int j = i; j < W.length(); j++) {
                    if (W.charAt(i) == W.charAt(j))
                        k++;
                    if (K == k) {
                        ans[0] = Math.min(ans[0], j - i + 1);
                        ans[1] = Math.max(ans[1], j - i + 1);
                        break;
                    }
                }
            }
            if (ans[0] == Integer.MAX_VALUE || ans[1] == Integer.MIN_VALUE)
                bw.write(-1 + "\n");
            else
                bw.write(ans[0] + " " + ans[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
