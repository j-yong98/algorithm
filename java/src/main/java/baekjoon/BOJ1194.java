package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1194 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char WALL = '#';
    final char BLANK = '.';
    int N, M;
    char[][] arr;
    boolean[][][] visited;
    int[] start = new int[2];

    /**
     * 달이 차오른다, 가자.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[1 << 6][N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '0') {
                    start[0] = i;
                    start[1] = j;
                    arr[i][j] = BLANK;
                }
            }
        }
        System.out.println(findGoal());
    }

    private int findGoal() {
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{start[0], start[1], 0, 0});
        visited[0][start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] pos = q.pollFirst();

            if (arr[pos[0]][pos[1]] == '1')
                return pos[3];
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];

                if (!inRange(yy, xx)) continue;
                if (arr[yy][xx] >= 'a' && arr[yy][xx] <= 'f') {
                    if (visited[pos[2] | (1 << (arr[yy][xx] - 'a'))][yy][xx]) continue;
                    q.add(new int[]{yy, xx, pos[2] | (1 << (arr[yy][xx] - 'a')), pos[3] + 1});
                    visited[pos[2] | (1 << (arr[yy][xx] - 'a'))][yy][xx] = true;
                } else if (arr[yy][xx] >= 'A' && arr[yy][xx] <= 'F') {
                    if ((pos[2] & (1 << (arr[yy][xx] - 'a'))) == 0) continue;
                    if (visited[pos[2]][yy][xx]) continue;
                    q.add(new int[]{yy, xx, pos[2], pos[3] + 1});
                    visited[pos[2]][yy][xx] = true;
                } else {
                    if (arr[yy][xx] == WALL || visited[pos[2]][yy][xx]) continue;
                    q.add(new int[]{yy, xx, pos[2], pos[3] + 1});
                    visited[pos[2]][yy][xx] = true;
                }
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
