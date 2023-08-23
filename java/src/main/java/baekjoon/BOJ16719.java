package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16719 {
    String str;
    int N;
    boolean[] checked;
    StringBuilder sb = new StringBuilder();

    /**
     * ZOAC
     * 재귀 문제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
        checked = new boolean[N];
        dfs(0, N);
        System.out.print(sb);
    }

    private void dfs(int start, int end) {
        if (start == N || end == 0 || start == end) return;
        char min = 'Z' + 1;
        int idx = -1;
        for (int i = start; i < end; i++) {
            if (Character.compare(str.charAt(i), min) < 0) {
                min = str.charAt(i);
                idx = i;
            }
        }
        checked[idx] = true;
        for (int i = 0; i < N; i++) {
            if (!checked[i]) continue;
            sb.append(str.charAt(i));
        }
        sb.append("\n");
        dfs(idx + 1, end);
        dfs(start, idx);
    }
}
