package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ20058 {
     final int BLANK = 0;
     int n, q;
     int[][] arr;
     int size;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2, n);
        arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int l = Integer.parseInt(st.nextToken());
            div(l);
            melt();
        }
        bw.write(Arrays.stream(arr).flatMapToInt(Arrays::stream).sum() + "\n");
        bw.write(getChunk() + "\n");
        bw.flush();
        bw.close();
    }
    private void div(int l) {
        int step = (int)Math.pow(2, l);
        for (int i = 0; i < size; i+=step) {
            for (int j = 0; j < size; j+=step) {
                int[][] a = new int[step][step];
                for (int r = 0; r < step; r++) {
                    for (int  c = 0; c < step; c++)
                        a[r][c] = arr[r + i][c + j];
                }
                a = rotate(a, step);
                for (int r = 0; r < step; r++) {
                    for (int c = 0; c < step; c++)
                        arr[r + i][c + j] = a[r][c];
                }
            }
        }
    }
    private int[][] rotate(int[][] a, int s) {
        int[][] tmp = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                tmp[i][j] = a[s - j - 1][i];
            }
        }
        return tmp;
    }
    private int getChunk() {
        boolean[][] visited = new boolean[size][size];
        int c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && arr[i][j] != BLANK) {
                    visited[i][j] = true;
                    c = Math.max(c, bfs(visited, i, j));
                }
            }
        }
        return c;
    }
    private int bfs(boolean[][] visited, int r, int c) {
        int cnt = 1;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Deque<int[]> q = new ArrayDeque();
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != BLANK) {
                    cnt++;
                    visited[y][x] = true;
                    q.add(new int[]{y, x});
                }
            }
        }
        return cnt;
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < size && x >= 0 && x < size;
    }
    private void melt() {
        int[][] tmp = new int[size][size];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] != BLANK) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int y = i + dy[d];
                        int x = j + dx[d];
                        if (inRange(y, x) && arr[y][x] != BLANK)
                            cnt++;
                    }
                    if (cnt < 3)
                        tmp[i][j] = arr[i][j] - 1;
                    else
                        tmp[i][j] = arr[i][j];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                arr[i][j] = tmp[i][j];
        }
    }
}
