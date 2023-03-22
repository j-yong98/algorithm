package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16985 {
    final int N = 5;
    int[] visited = new int[N];
    int[][][] arr = new int[N][N][N];
    int[][][] dist = new int[N][N][N];
    int[] dz = {-1, 1, 0, 0, 0, 0};
    int[] dy = {0, 0, 1, -1, 0, 0};
    int[] dx = {0, 0, 0, 0, 1, -1};
    List<int[][]> maps = new ArrayList<>();
    Deque<int[]> q = new ArrayDeque<>();

    int ans = Integer.MAX_VALUE;

    public void printMap(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] rotate(int[][] map) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[j][N - 1 - i] = map[i][j];
            }
        }
        return tmp;
    }
    private int[][][] init() {
        int[][][] tmp = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dist[i][j][k] = 1000;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmp[i][j][k] = maps.get(i)[j][k];
                }
            }
        }
        return tmp;
    }

    private boolean inRange(int z, int y, int x) {
        return z >= 0 && z < N && y >= 0 && y < N && x >= 0 && x < N;
    }
    private void orderShuffle(int idx) {
        if (idx == N) {
            ans = Math.min(ans, bfs());
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                maps.add(arr[i]);
                orderShuffle(idx + 1);
                maps.remove(maps.size() - 1);
                visited[i] = 0;
            }
        }
    }
    private void rec(int seq) {
        if (seq == N) {
            orderShuffle(0);
            return ;
        }
        for (int i = 0; i < 4; i++) {
            arr[seq] = rotate(arr[seq]);
            rec(seq + 1);
        }
    }

    private int bfs() {
        int[][][] tmp = init();
        if (tmp[0][0][0] == 0 || tmp[N - 1][N - 1][N - 1] == 0)
            return 1000;
        dist[0][0][0] = 0;
        q.addLast(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == N - 1 && pos[1] == N - 1 && pos[2] == N - 1)
                return dist[N - 1][N - 1][N - 1];
            for (int i = 0; i < 6; i++) {
                int z = pos[0] + dz[i];
                int y = pos[1] + dy[i];
                int x = pos[2] + dx[i];
                if (inRange(z, y, x) && dist[z][y][x] == 1000 && tmp[z][y][x] == 1) {
                    q.addLast(new int[]{z, y, x});
                    dist[z][y][x] = dist[pos[0]][pos[1]][pos[2]] + 1;
                }
            }
        }
        return 1000;
    }

    /**
     * Maaaaaaaaaze
     * 5x5 배열이 5개 주어지는데
     * 각 배열을 회전 시킬 수 있고 -> 각 2차원 배열을 회전시키는 함수
     * 순서를 마음 대로 할 수 있다. -> 쌓는 순서 순열 함수
     * 0,0 -> 4,4 로 가는 최단 거리를 구하라
     * 각 2차원 배열을 회전시키는 경우의 수에 쌓는 순서 경우의 수 합치기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        rec(0);
        System.out.println(ans == 1000 ? -1 : ans);
    }
}
