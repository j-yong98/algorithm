package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ16235 {
    int n, m, k;
    int[][] foods;
    int[][] additionalFood;
    Deque<int[]> trees = new LinkedList<>();
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    private void invest() {
        while (k-- > 0) {
            Queue<int[]> deadTree = new LinkedList<>();
            for (int i = 0; i < trees.size();) {
                int[] tree = trees.poll();
                if (foods[tree[0]][tree[1]] >= tree[2]) {
                    foods[tree[0]][tree[1]] -= tree[2];
                    tree[2] += 1;
                    trees.add(tree);
                    i++;
                } else
                    deadTree.add(tree);
            }
            for (int[] tree : deadTree)
                foods[tree[0]][tree[1]] += tree[2] / 2;
            Queue<int[]> newTree = new LinkedList<>();
            for (int[] tree : trees) {
                if (tree[2] % 5 == 0)
                    newTree.add(tree);
            }
            while(!newTree.isEmpty()) {
                int[] tree = newTree.poll();
                for (int i = 0; i < 8; i++) {
                    int y = tree[0] + dy[i];
                    int x = tree[1] + dx[i];
                    if (y >= 0 && y < n && x >= 0 && x < n)
                        trees.addFirst(new int[]{y, x, 1});
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    foods[i][j] += additionalFood[i][j];
            }
        }
    }

    private void init() {
        foods = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                foods[i][j] = 5;
        }
    }

    /**
     * 나무 재테크
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        additionalFood = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                additionalFood[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new int[]{y, x, age});
        }
        init();
        invest();
        bw.write(trees.size() + "\n");
        bw.flush();
        bw.close();
    }
}
