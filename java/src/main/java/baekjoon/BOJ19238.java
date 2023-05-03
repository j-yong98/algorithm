package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19238 {
    class Passenger {
        int[] depart;
        int[] arrival;

        public Passenger(int[] depart, int[] arrival) {
            this.depart = depart;
            this.arrival = arrival;
        }
    }

    final int WALL = 1;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, 1, -1};

    int n, m, f;
    int[][] arr;
    int y, x;
    int[] depart;
    int[] departToArrival;
    boolean[] visited;
    List<Passenger> passengers = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        depart = new int[m];
        departToArrival = new int[m];
        visited = new boolean[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken()) - 1;
            int s2 = Integer.parseInt(st.nextToken()) - 1;
            int e1 = Integer.parseInt(st.nextToken()) - 1;
            int e2 = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(new int[]{s1, s2}, new int[]{e1, e2}));
        }
        ans = getFuel();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    private int getFuel() {
        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] d = passengers.get(i).depart;
            int[] a = passengers.get(i).arrival;
            departToArrival[i] = getDist(d, a);
        }

        for (int i = 0; i < m; i++) {
            int dist = getDist(new int[]{y, x}, passengers.get(i).depart);
            if (dist == -1)
                continue;
            start.add(new int[]{dist, i});
        }
        if (start.size() == 0)
            return -1;

        Collections.sort(start, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    Passenger p1 = passengers.get(o1[1]);
                    Passenger p2 = passengers.get(o2[1]);
                    if (p1.depart[0] == p2.depart[0])
                        return Integer.compare(p1.depart[1], p2.depart[1]);
                    return Integer.compare(p1.depart[0], p2.depart[0]);
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < start.size(); i++) {
            int[] s = start.get(i);
            for (int j = 0; j < m; j++)
                visited[i] = false;
            int fuel = f - s[0] - departToArrival[s[1]];
            visited[s[1]] = true;
            int res = move(1, s[1], fuel);
            if (res != -1)
                return res;
        }
        return -1;
    }

    private int move(int cnt, int idx, int fuel) {
        if (fuel < 0)
            return -1;
        if (cnt == m)
            return fuel + 2 * departToArrival[idx];
        fuel += 2 * departToArrival[idx];
        int min = Integer.MAX_VALUE;
        int next = -1;
        for (int i = 0; i < m; i++) {
            if (visited[i])
                continue;
            int dist = getDist(passengers.get(idx).arrival, passengers.get(i).depart);
            if (dist == -1)
                continue;
            if (dist < min) {
                min = dist;
                next = i;
            }
            else if (dist == min) {
                int[] p1 = passengers.get(next).depart;
                int[] p2 = passengers.get(i).depart;
                if (p1[0] > p2[0])
                    next = i;
                else if (p1[0] == p2[0]) {
                    if (p1[1] > p2[1])
                        next = i;
                }
            }
        }
        if (next == -1)
            return -1;
        visited[next] = true;
        return move(cnt + 1, next, fuel - min - departToArrival[next]);
    }

    private int getDist(int[] depart, int[] arrival) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] checked = new boolean[n][n];
        q.add(new int[]{depart[0], depart[1], 0});
        checked[depart[0]][depart[1]] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (arrival[0] == pos[0] && arrival[1] == pos[1])
                return pos[2];
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !checked[yy][xx] && arr[yy][xx] != WALL) {
                    checked[yy][xx] = true;
                    q.add(new int[]{yy, xx, pos[2] + 1});
                }
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
