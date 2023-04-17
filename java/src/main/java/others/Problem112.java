package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem112 {
    final char ROOK = 'O';
    final int SIZE = 8;
    int T;
    char[][] map = new char[SIZE][SIZE];
    private String check() {
        int cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '.')
                    continue;
                cnt++;
                for (int k = 0; k < SIZE; k++) {
                    if (k == j) continue;
                    if (map[i][k] == ROOK)
                        return "no";
                }

                for (int k = 0; k < SIZE; k++) {
                    if (k == i) continue;
                    if (map[k][j] == ROOK)
                        return "no";
                }
            }
        }
        if (cnt != 8)
            return "no";
        return "yes";
    }
    /**
     * 체스판 위의 룩 배치
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 8; i++) {
                char[] row = br.readLine().toCharArray();
                map[i] = row;
            }
            System.out.println("#" + t + " " + check());
        }
    }
}
