package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17472 {
    final int BLANK = 0;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};

    int N, M;
    int[][] arr;
    int[] parent;
    int size;
    PriorityQueue<Node> pq = new PriorityQueue<>();

    class Node implements Comparable<Node>{
        int a;
        int b;
        int length;

        public Node(int a, int b, int length) {
            this.a = a;
            this.b = b;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        size = init();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != BLANK) {
                    for (int d = 0; d < 4; d++)
                        createBridge(i, j, d, arr[i][j], -1);
                }
            }
        }

        bw.write(getMinLen(size) + "\n");
        bw.flush();
        bw.close();
    }

    private int init() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    bfs(cnt, i, j, visited);
                }
            }
        }
        return cnt;
    }

    private void bfs(int num, int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        arr[y][x] = num;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] == 1) {
                    arr[yy][xx] = num;
                    visited[yy][xx] = true;
                    q.add(new int[]{yy, xx});
                }
            }
        }
    }

    private void createBridge(int y, int x, int dir, int num, int len) {
        if (arr[y][x] != BLANK && arr[y][x] != num) {
            if (len >= 2)
                pq.add(new Node(num, arr[y][x], len));
            return ;
        }
        int yy = y + dy[dir];
        int xx = x + dx[dir];
        if (!inRange(yy, xx) || arr[yy][xx] == num)
            return ;
        createBridge(yy, xx, dir, num, len + 1);
    }

    private int getMinLen(int size) {
        parent = new int[size + 1];
        for (int i = 1; i <= size; i++)
            parent[i] = i;

        int len = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int a = findParent(node.a);
            int b = findParent(node.b);
            if (a != b) {
                union(a, b);
                len += node.length;
                cnt++;
            }
        }
        if (len == 0 || cnt != size - 1)
            return -1;
        return len;
    }

    private void union(int a, int b) {
        parent[a] = b;
    }

    private int findParent(int num) {
        if (parent[num] == num)
            return num;
        return findParent(parent[num]);
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
