package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ21609 {
    final int BLANK = -2;
    final int BLACK = -1;
    final int RAINBOW = 0;
    int n, m;
    int[][] arr;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    int ans = 0;
    /**
     * 상어 중학교
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            int res = findBlockGroup();
            if (res == 0)
                break;
            ans += res;
            gravity();
            rotate();
            gravity();
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
    private void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] == -2 ? "B " : arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("==================================");
    }
    private void rotate() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = arr[j][n - 1 - i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = tmp[i][j];
        }
    }
    private void gravity() {
        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++)
                tmp[j] = BLANK;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == BLANK)
                    continue;
                if (arr[j][i] == BLACK) {
                    tmp[j] = BLACK;
                    idx = j - 1;
                }
                else
                    tmp[idx--] = arr[j][i];
            }
            for (int j = 0; j < n; j++)
                arr[j][i] = tmp[j];
        }
    }
    private int findBlockGroup() {
        Deque<int[]> maxBlockGroup = null;
        int[] max = new int[]{2, -1, -1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != BLACK && arr[i][j] != RAINBOW && arr[i][j] != BLANK) {
                    Deque<int[]> tmp = blockGroup(max, i, j);
                    if (tmp != null)
                        maxBlockGroup = tmp;
                }
            }
        }
        if (maxBlockGroup == null)
            return 0;
        while (!maxBlockGroup.isEmpty()) {
            int[] pos = maxBlockGroup.pollFirst();
            arr[pos[0]][pos[1]] = BLANK;
        }
        return (int) Math.pow(max[0], 2);
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private Deque<int[]> blockGroup(int[] max, int y, int x) {
        Deque<int[]> ret = new ArrayDeque<>();
        Deque<int[]> tmp = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int rainbowCnt = 0;
        int cnt = 1;
        int r = y;
        int c = x;
        tmp.add(new int[]{y, x});
        visited[y][x] = true;
        while (!tmp.isEmpty()) {
            int[] pos = tmp.pollFirst();
            ret.add(pos);
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && (arr[y][x] == arr[yy][xx] || arr[yy][xx] == RAINBOW)
                        && !visited[yy][xx] && arr[yy][xx] != BLACK && arr[yy][xx] != BLANK) {
                    cnt++;
                    if (arr[yy][xx] != RAINBOW) {
                        if (r > yy) {
                            r = yy;
                            c = xx;
                        }
                        else if (r == yy) {
                            if (c > xx) {
                                r = yy;
                                c = xx;
                            }
                        }
                    }
                    else
                        rainbowCnt++;
                    visited[yy][xx] = true;
                    tmp.add(new int[]{yy, xx});
                }
            }
        }
        if (max[0] < cnt) {
            max[0] = cnt;
            max[1] = r;
            max[2] = c;
            max[3] = rainbowCnt;
            return ret;
        }
        if (max[0] == cnt) {
            if (max[3] < rainbowCnt) {
                max[1] = r;
                max[2] = c;
                max[3] = rainbowCnt;
                return ret;
            }
            else if (max[3] == rainbowCnt) {
                if (max[1] < r) {
                    max[1] = r;
                    max[2] = c;
                    return ret;
                }
                else if (max[1] == r) {
                    if (max[2] < c) {
                        max[2] = c;
                        return ret;
                    }
                }
            }
        }
        return null;
    }
}
