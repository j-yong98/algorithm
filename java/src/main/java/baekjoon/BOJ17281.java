package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17281 {
    int n;
    int[][] innings;
    int[] hitters = new int[9];
    boolean[] visited = new boolean[9];
    int ans = 0;
    int hitter;
    private int calc(int inning) {
        int strike = 0;
        boolean[] base = new boolean[3];
        int sum = 0;
        while (strike < 3) {
            int hit = innings[inning][hitters[hitter]];
            if (hit == 0)
                strike++;
            else if (hit == 1) {
                for (int i = 2; i >= 0; i--) {
                    if (base[i] && i == 2) {
                        sum++;
                        base[i] = false;
                    }
                    if (base[i]) {
                        base[i + 1] = true;
                        base[i] = false;
                    }
                }
                base[0] = true;
            }
            else if (hit == 2) {
                for (int i = 2; i >= 0; i--) {
                    if (base[i] && i >= 1) {
                        sum++;
                        base[i] = false;
                    }
                    else if (base[i]) {
                        base[i + 2] = true;
                        base[i] = false;
                    }
                }
                base[1] = true;
            }
            else if (hit == 3) {
                for (int i = 2; i >= 0; i--) {
                    if (base[i]) {
                        sum++;
                        base[i] = false;
                    }
                }
                base[2] = true;
            }
            else {
                for (int i = 0; i < 3; i++) {
                    if (base[i]) {
                        sum++;
                        base[i] = false;
                    }
                }
                sum++;
            }
            hitter = (hitter + 1) % 9;
        }
        return sum;
    }
    private void perm(int seq) {
        if (seq == 9) {
            int score = 0;
            hitter = 0;
            for (int i = 0; i < n; i++)
                score += calc(i);
            ans = Math.max(ans, score);
            return ;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                hitters[i] = seq;
                visited[i] = true;
                perm(seq + 1);
                visited[i] = false;
            }
        }
    }
    /**
     * ⚾️
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        innings = new int[n][9];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                innings[i][j] = Integer.parseInt(st.nextToken());
        }
        hitters[3] = 0;
        visited[3] = true;
        perm(1);
        System.out.println(ans);
    }
}
