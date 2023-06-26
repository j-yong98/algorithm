package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BOJ13913 {
    final int MAX = 100_000;
    int n, k;
    Deque<Path> q = new ArrayDeque<>();
    boolean[] visited = new boolean[MAX + 1];
    Path ans = new Path(MAX + 1, MAX + 1);
    int[] p = new int[MAX + 1];
    /**
     * 숨바꼭질 4
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        visited[n] = true;
        q.add(new Path(n, 0));
        while (!q.isEmpty()) {
            Path path = q.pollFirst();
            if (path.pos == k) {
                bw.write(path.cnt + "\n");
                Stack<Integer> stack = new Stack<>();
                int idx = k;
                while (idx != n) {
                    stack.add(idx);
                    idx = p[idx];
                }
                stack.add(n);
                while(!stack.isEmpty())
                    bw.write(stack.pop() + " ");
                break ;
            }
            if (path.pos + 1 <= MAX && !visited[path.pos + 1]) {
                q.add(new Path(path.pos + 1, path.cnt + 1));
                visited[path.pos + 1] = true;
                p[path.pos + 1] = path.pos;
            }
            if (path.pos - 1 >= 0 && !visited[path.pos - 1]) {
                q.add(new Path(path.pos - 1, path.cnt + 1));
                visited[path.pos - 1] = true;
                p[path.pos - 1] = path.pos;
            }
            if (path.pos * 2 <= MAX && !visited[path.pos * 2]) {
                q.add(new Path(path.pos * 2, path.cnt + 1));
                visited[path.pos * 2] = true;
                p[path.pos * 2] = path.pos;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    class Path {
        int pos;
        int cnt;

        public Path(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
