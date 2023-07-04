package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ9328 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char BLANK = '.';
    final char DOC = '$';
    final char WALL = '*';
    boolean flag;
    int T;
    int h, w;
    char[][] arr;
    boolean[][] visited;
    HashMap<Character, List<int[]>> keys = new HashMap<>();
    int ans;

    /**
     * 열쇠
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            h = Integer.parseInt(line[0]);
            w = Integer.parseInt(line[1]);
            arr = new char[h][w];
            visited = new boolean[h][w];
            keys.clear();
            ans = 0;
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (Character.isUpperCase(arr[i][j])) {
                        if (!keys.containsKey(arr[i][j])) {
                            List<int[]> pos = new ArrayList<>();
                            pos.add(new int[]{i, j});
                            keys.put(arr[i][j], pos);
                        } else
                            keys.get(arr[i][j]).add(new int[]{i, j});
                    }
                }
            }
            String str = br.readLine();
            if (!str.equals("0")) {
                for (int i = 0; i < str.length(); i++) {
                    char ch = Character.toUpperCase(str.charAt(i));
                    if (keys.containsKey(ch)) {
                        List<int[]> pos = keys.get(ch);
                        for (int[] p : pos)
                            arr[p[0]][p[1]] = BLANK;
                    }
                }
            }
            getStart();
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void getStart() {
        flag = false;
        for (int i = 0; i < h; i++) {
            if (arr[i][0] == BLANK || arr[i][0] == DOC || Character.isLowerCase(arr[i][0]))
                getKey(i, 0);
            if (arr[i][w - 1] == BLANK || arr[i][w - 1] == DOC || Character.isLowerCase(arr[i][w - 1]))
                getKey(i, w - 1);
        }
        for (int j = 0; j < w; j++) {
            if (arr[0][j] == BLANK || arr[0][j] == DOC || Character.isLowerCase(arr[0][j]))
                getKey(0, j);
            if (arr[h - 1][j] == BLANK || arr[h - 1][j] == DOC || Character.isLowerCase(arr[h - 1][j]))
                getKey(h - 1, j);
        }
        if (flag)
            getStart();
    }

    private void getKey(int y, int x) {
        if (arr[y][x] == DOC) {
            ans += 1;
            arr[y][x] = BLANK;
        } else if (Character.isLowerCase(arr[y][x]))
            removeLock(y, x);
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++)
            Arrays.fill(visited[i], false);

        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] != WALL) {
                    if (Character.isUpperCase(arr[yy][xx])) continue;
                    visited[yy][xx] = true;
                    q.add(new int[]{yy, xx});
                    if (Character.isLowerCase(arr[yy][xx])) {
                        char ch = Character.toUpperCase(arr[yy][xx]);
                        removeLock(yy, xx);
                    } else if (arr[yy][xx] == DOC) {
                        ans += 1;
                        arr[yy][xx] = BLANK;
                    }
                }
            }
        }
    }

    private void removeLock(int y, int x) {
        char ch = Character.toUpperCase(arr[y][x]);
        if (keys.containsKey(ch)) {
            List<int[]> key = keys.get(ch);
            for (int[] p : key)
                arr[p[0]][p[1]] = BLANK;
            arr[y][x] = BLANK;
            flag = true;
        }
    }

    private void printMap() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("========================");
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}
