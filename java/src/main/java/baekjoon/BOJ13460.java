package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ13460 {
    class Ball {
        int blueY = -1;
        int blueX = -1;
        int redY = -1;
        int redX = -1;
        int cnt = 0;

        public Ball() {
        }

        public Ball(int blueY, int blueX, int redY, int redX, int cnt) {
            this.blueY = blueY;
            this.blueX = blueX;
            this.redY = redY;
            this.redX = redX;
            this.cnt = cnt;
        }
    }

    final int MAX = 11;
    final Ball ball = new Ball();
    int n, m;
    char[][] board;
    boolean[][][][] checked;
    private int bfs() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        ArrayDeque<Ball> q = new ArrayDeque<>();
        q.add(ball);
        while (!q.isEmpty()) {
            Ball now = q.pollFirst();
            if (board[now.redY][now.redX] == 'O')
                return now.cnt;
            for (int i = 0; i < 4; i++) {
                int ry = now.redY;
                int rx = now.redX;
                int by = now.blueY;
                int bx = now.blueX;
                int rCnt = 0;
                int bCnt = 0;
                while (
                        board[ry][rx] != 'O' &&
                        board[ry + dy[i]][rx + dx[i]] != '#'
                ) {
                    ry += dy[i];
                    rx += dx[i];
                    rCnt++;
                }
                while (
                        board[by][bx] != 'O' &&
                        board[by + dy[i]][bx + dx[i]] != '#'
                ) {
                    by += dy[i];
                    bx += dx[i];
                    bCnt++;
                }
                if (board[by][bx] == 'O')
                    continue;
                if (ry == by && rx == bx) {
                    if (rCnt > bCnt) {
                        ry -= dy[i];
                        rx -= dx[i];
                    }
                    else {
                        by -= dy[i];
                        bx -= dx[i];
                    }
                }
                if (checked[ry][rx][by][bx])
                    continue;
                if (now.cnt < 10) {
                    q.add(new Ball(by, bx, ry, rx, now.cnt + 1));
                    checked[ry][rx][by][bx] = true;
                }
            }
        }
        return -1;
    }

    /**
     * 구슬 탈출 2
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        checked = new boolean[n][m][n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = str.charAt(j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    ball.redY = i;
                    ball.redX = j;
                } else if (board[i][j] == 'B') {
                    ball.blueY = i;
                    ball.blueX = j;
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);
        return ans;
    }
}
