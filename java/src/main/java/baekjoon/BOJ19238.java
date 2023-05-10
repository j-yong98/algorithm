package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19238 {
    class Pos implements Comparable<Pos>{
        int r;
        int c;
        int cnt;

        public Pos() {
        }

        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.cnt == o.cnt) {
                if (this.r == o.r)
                    return this.c - o.c;
                return this.r - o.r;
            }
            return this.cnt - o.cnt;
        }
    }

    final int BLOCK = -1;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, 1, -1};
    int n, m, k;
    int[][] arr;
    Pos[] des;
    boolean[][] visited;
    Pos taxi = new Pos();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        des = new Pos[m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i][j] == 1 ? BLOCK : arr[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        taxi.r = Integer.parseInt(st.nextToken());
        taxi.c = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = i;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            des[i] = new Pos(r, c, 0);
        }
        for (int i = 0; i < m; i++) {
            int passenger = findPassenger();
            k -= taxi.cnt;
            if (k <= 0 || passenger == -1) {
                k = -1;
                break ;
            }

            int fuel = goDest(passenger);
            if (k < fuel || fuel == -1) {
                k = -1;
                break ;
            }
            k += fuel;
        }
        bw.write(k + "\n");
        bw.flush();
        bw.close();
    }

    private int findPassenger() {
        Deque<Pos> q = new ArrayDeque<>();
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            Arrays.fill(visited[i], false);
        taxi.cnt = 0;
        q.add(taxi);
        visited[taxi.r][taxi.c] = true;
        if (arr[taxi.r][taxi.c] > 0)
            return arr[taxi.r][taxi.c];
        while (!q.isEmpty()) {
            Pos pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos.r + dy[i];
                int x = pos.c + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != BLOCK) {
                    if (arr[y][x] > 0)
                        pq.add(new Pos(y, x, pos.cnt + 1));
                    q.add(new Pos(y, x, pos.cnt + 1));
                    visited[y][x] = true;
                }
            }
        }
        if (!pq.isEmpty()) {
            taxi = pq.poll();
            return arr[taxi.r][taxi.c];
        }
        return -1;
    }

    private int goDest(int p) {
        Deque<Pos> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            Arrays.fill(visited[i], false);
        taxi.cnt = 0;
        q.add(taxi);
        visited[taxi.r][taxi.c] = true;
        while (!q.isEmpty()) {
            Pos pos = q.pollFirst();
            if (pos.r == des[p].r && pos.c == des[p].c) {
                arr[taxi.r][taxi.c] = 0;
                taxi = pos;
                return taxi.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int y = pos.r + dy[i];
                int x = pos.c + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != BLOCK) {
                    q.add(new Pos(y, x, pos.cnt + 1));
                    visited[y][x] = true;
                }
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
    }
}
