package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ16933 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int n, m, k;
    int[][] arr;
    boolean[][][] visited;

    /**
     * 벽 부수고 이동하기 3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        arr = new int[n][m];
        visited = new boolean[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            String l = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = l.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
        br.close();
    }

    private int bfs() {
        Deque<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            if (node.y == n - 1 && node.x == m - 1)
                return node.d;
            for (int i = 0; i < 4; i++) {
                int y = node.y + dy[i];
                int x = node.x + dx[i];
                if ((y < 0 || y >= n || x < 0 || x >= m) || visited[node.wall][y][x]) continue;
                if (arr[y][x] == 0) {
                    visited[node.wall][y][x] = true;
                    int day = node.day == 1 ? 0 : 1;
                    q.add(new Node(y, x, node.wall, node.d + 1, day));
                } else {
                    if (node.day == 0 && node.wall < k) {
                        visited[node.wall + 1][y][x] = true;
                        q.add(new Node(y, x, node.wall + 1, node.d + 1, 1));
                    } else if (node.day == 1 && node.wall < k)
                        q.add(new Node(node.y, node.x, node.wall, node.d + 1, 0));
                }
            }
        }
        return -1;
    }

    class Node {
        int y, x, wall, d, day;

        public Node(int y, int x, int wall, int d, int day) {
            this.y = y;
            this.x = x;
            this.wall = wall;
            this.d = d;
            this.day = day;
        }
    }
}
