package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ20165 {
    final int[] dy = {0, 0, 1, -1};
    final int[] dx = {1, -1, 0, 0};
    int N, M, R;
    int[][] arr;
    boolean[][] status;
    int ans = 0;

    /**
     * 인내의 도미노 장인 호석
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        status = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);
            attack(r, c, getDir(dir));
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            defense(r, c);
        }

        printStatus();
    }

    private void printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(status[i][j] ? "F " : "S ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void attack(int r, int c, int dir) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.pollFirst();
                if (status[pos[0]][pos[1]]) continue;
                status[pos[0]][pos[1]] = true;
                ans++;
                for (int j = 0; j < arr[pos[0]][pos[1]]; j++) {
                    int y = pos[0] + dy[dir] * j;
                    int x = pos[1] + dx[dir] * j;
                    if (!inRange(y, x)) break;
                    q.add(new int[]{y, x});
                }
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    private void defense(int r, int c) {
        if (!status[r][c]) return;
        status[r][c] = false;
    }

    private int getDir(char d) {
        if (d == 'E') return 0;
        if (d == 'W') return 1;
        if (d == 'S') return 2;
        if (d == 'N') return 3;
        return -1;
    }
}
