package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1786 {
    int[] table;
    int N, M;
    int cnt;
    String T;
    String P;
    List<Integer> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    /**
     * 찾기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();
        N = T.length();
        M = P.length();
        table = new int[M];
        int j = 0;
        for (int i = 1; i < M; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j))
                j = table[j - 1];
            if (P.charAt(i) == P.charAt(j))
                table[i] = ++j;
        }

        j = 0;
        for (int i = 0; i < N; i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j))
                j = table[j - 1];
            if (T.charAt(i) == P.charAt(j)) {
                if (j == M - 1) {
                    ans.add(i - M + 1);
                    j = table[j];
                } else
                    j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for (int a : ans)
            sb.append(a + 1).append("\n");
        System.out.print(sb);
        br.close();
    }
}
