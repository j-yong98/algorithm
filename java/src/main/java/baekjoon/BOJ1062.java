package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1062 {
    final int SIZE = 26;
    int N, K;
    List<String> words = new ArrayList<>();
    int ans = 0;
    boolean[] alpha = new boolean[SIZE];
    /**
     * 가르침
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            words.add(line.substring(4, line.length() - 4));
        }
        if (K < 5)
            System.out.println(0);
        else {
            dfs(0, 0);
            System.out.println(ans);
        }
        br.close();
    }

    private void dfs(int l, int s) {
        if (l == K - 5) {
            int cnt = 0;
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                boolean canRead = true;
                for (int j = 0; j < word.length(); j++) {
                    int idx = word.charAt(j) - 'a';
                    if (!alpha[idx]) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = s; i < 26; i++) {
            if (alpha[i]) continue;
            alpha[i] = true;
            dfs(l + 1, i + 1);
            alpha[i] = false;
        }
    }
}
