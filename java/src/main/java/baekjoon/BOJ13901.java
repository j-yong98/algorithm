package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13901 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int WALL = 1;
    int R, C;
    int K;
    int[][] arr;
    int[] pos = new int[2];
    boolean[][] visited;
    int[] cmd = new int[4];

    /**
     * 로봇
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = WALL;
        }
        st = new StringTokenizer(br.readLine());
        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            cmd[i] = Integer.parseInt(st.nextToken()) - 1;
        move();
        System.out.println(pos[0] + " " + pos[1]);
        br.close();
    }

    private void move() {
        int dir = 0;
        visited[pos[0]][pos[1]] = true;

        int repeat = 0;
        while (true) {
            if (repeat == 4) break;
            int yy = pos[0] + dy[cmd[dir]];
            int xx = pos[1] + dx[cmd[dir]];
            if (!inRange(yy, xx) || arr[yy][xx] == WALL || visited[yy][xx]) {
                dir = (dir + 1) % 4;
                repeat++;
                continue;
            }
            repeat = 0;
            visited[yy][xx] = true;
            pos[0] = yy;
            pos[1] = xx;
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
