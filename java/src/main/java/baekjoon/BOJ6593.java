package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ6593 {
    final char START = 'S';
    final char OBSTACLE = '#';
    final char END = 'E';
    final int[] dz = {0, 0, 0, 0, -1, 1};
    final int[] dy = {0, 0, 1, -1, 0, 0};
    final int[] dx = {1, -1, 0, 0, 0, 0};

    int L, R, C;
    char[][][] building;
    boolean[][][] visited;
    int[] s = new int[3];

    /**
     *  상범 빌딩
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] line = br.readLine().split(" ");
            L = Integer.parseInt(line[0]);
            R = Integer.parseInt(line[1]);
            C = Integer.parseInt(line[2]);
            if (L == 0 && R == 0 && C == 0)
                break;
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == START) {
                            s[0] = i;
                            s[1] = j;
                            s[2] = k;
                        }
                    }
                }
                br.readLine();
            }
            int ans = bfs();
            if (ans == -1)
                bw.write("Trapped!\n");
            else
                bw.write("Escaped in " + ans + " minute(s).\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s[0], s[1], s[2], 0});
        visited[s[0]][s[1]][s[2]] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (building[pos[0]][pos[1]][pos[2]] == END)
                return pos[3];
            for (int i = 0; i < 6; i++) {
                int z = pos[0] + dz[i];
                int y = pos[1] + dy[i];
                int x = pos[2] + dx[i];
                if (inRange(z, y, x) && !visited[z][y][x] && building[z][y][x] != OBSTACLE) {
                    visited[z][y][x] = true;
                    q.add(new int[]{z, y, x, pos[3] + 1});
                }
            }
        }
        return -1;
    }

    private boolean inRange(int z, int y, int x) {
        return z >= 0 && z < L && y >= 0 && y < R && x >= 0 && x < C;
    }
}
