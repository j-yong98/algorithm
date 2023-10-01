package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6087 {
    final int MAX = 1_000_000_000;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char BLANK = '.';
    final char WALL = '*';
    int[][] C = new int[2][];
    int H, W;
    char[][] arr;

    /**
     * 레이저 통신
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new char[H][W];
        int idx = 0;
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'C') {
                    C[idx++] = new int[]{i, j};
                    arr[i][j] = BLANK;
                }
            }
        }
        int ans = MAX;
        for (int i = 0; i < 4; i++) {
            int y = C[0][0] + dy[i];
            int x = C[0][1] + dx[i];
            if (!inRange(y, x) || arr[y][x] == WALL) continue;
            ans = Math.min(ans, findAnswer(y, x, i));
        }
        System.out.println(ans);
        br.close();
    }

    private int findAnswer(int y, int x, int dir) {
        int ans = MAX;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.count, b.count));
        pq.add(new Node(y, x, dir, 0));

        int[][] dist = new int[H][W];
        for (int i = 0; i < H; i++)
            Arrays.fill(dist[i], MAX);
        dist[C[0][0]][C[0][1]] = 0;
        dist[y][x] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.count > dist[now.y][now.x]) continue;
            if (now.y == C[1][0] && now.x == C[1][1]) ans = Math.min(ans, now.count);

            for (int i = 0; i < 4; i++) {
                if ((now.prevDir ^ i) == 1) continue;
                int yy = now.y + dy[i];
                int xx = now.x + dx[i];
                int cnt = now.prevDir != i ? now.count + 1 : now.count;
                if (!inRange(yy, xx) || arr[yy][xx] == WALL || dist[yy][xx] <= cnt) continue;
                dist[yy][xx] = cnt;
                pq.add(new Node(yy, xx, i, dist[yy][xx]));
            }
        }
        return ans;
    }

    private void printMap(int[][] dist) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++)
                System.out.print(dist[i][j] == MAX ? "-  " : dist[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    static class Node {
        int y;
        int x;
        int prevDir;
        int count;

        public Node(int y, int x, int prevDir, int count) {
            this.y = y;
            this.x = x;
            this.prevDir = prevDir;
            this.count = count;
        }
    }
}
