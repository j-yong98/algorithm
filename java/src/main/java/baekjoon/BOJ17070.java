package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
    class Pipe {
        int[] head;
        int[] tail;
        int dir;

        public Pipe(int[] head, int[] tail, int dir) {
            this.head = head;
            this.tail = tail;
            this.dir = dir;
        }
    }
    final int WALL = 1;
    int n;
    int[][] arr;

    int[][] canGo = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};
    int ans = 0;

    private boolean moveRight(int y, int x) {
        return y < n && x + 1 < n && arr[y][x + 1] != WALL;
    }

    private boolean moveDown(int y, int x) {
        return y + 1 < n && x < n && arr[y + 1][x] != WALL;
    }

    private boolean moveCross(int y, int x) {
        return moveRight(y, x) && moveDown(y, x) && y + 1 < n && x + 1< n && arr[y + 1][x + 1] != WALL;
    }
    private void move(Pipe pipe) {
        if (pipe.head[0] == n - 1 && pipe.head[1] == n - 1) {
            ans += 1;
            return ;
        }
        for (int i = 0; i < 3; i++) {
            if (canGo[pipe.dir][i] == 1) {
                if (i == 0) {
                    if (moveRight(pipe.head[0], pipe.head[1]))
                        move(new Pipe(new int[]{pipe.head[0], pipe.head[1] + 1}, new int[]{pipe.head[0], pipe.head[1]}, 0));
                }
                else if (i == 1) {
                    if (moveDown(pipe.head[0], pipe.head[1]))
                        move(new Pipe(new int[]{pipe.head[0] + 1, pipe.head[1]}, new int[]{pipe.head[0], pipe.head[1]}, 1));
                }
                else {
                    if (moveCross(pipe.head[0], pipe.head[1]))
                        move(new Pipe(new int[]{pipe.head[0] + 1, pipe.head[1] + 1}, new int[]{pipe.head[0], pipe.head[1]}, 2));
                }
            }
        }
    }
    /**
     * 파이프 옮기기 1
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        Pipe pipe = new Pipe(new int[]{0, 1}, new int[]{0, 0}, 0);
        move(pipe);
        System.out.println(ans);
    }
}
