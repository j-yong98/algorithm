package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ11967 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int n, m;
    boolean[][] arr;
    boolean[][] visited;
    List<int[]>[][] onOff;

    /**
     * 불켜기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new boolean[n][n];
        onOff = new List[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                onOff[i][j] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int a = Integer.parseInt(line[2]) - 1;
            int b = Integer.parseInt(line[3]) - 1;
            onOff[x][y].add(new int[]{a, b});
        }
        bw.write((turnOn() + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int turnOn() {
        int on = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], false);

        arr[0][0] = true;
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        boolean flag = false;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            int len = onOff[pos[0]][pos[1]].size();
            for (int i = 0; i < len; i++) {
                int[] next = onOff[pos[0]][pos[1]].get(i);
                if (arr[next[0]][next[1]]) continue;
                on += 1;
                arr[next[0]][next[1]] = true;
                flag = true;
            }

            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x) || !arr[y][x] || visited[y][x]) continue;
                visited[y][x] = true;
                q.add(new int[]{y, x});
            }
        }
        if (flag)
            on += turnOn();
        return on;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
