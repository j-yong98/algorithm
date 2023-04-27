package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ21610 {
    int n, m;
    int[][] arr;
    int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    Deque<int[]> clouds = new ArrayDeque<>();
    boolean[][] checked;
    /**
     * 마법사 상어와 비바라기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        checked = new boolean[n][n];
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int repeat = Integer.parseInt(st.nextToken());
            move(dir, repeat);
            waterIncrease();
            createCloud();
        }
        int cnt = Arrays.stream(arr).flatMapToInt(Arrays::stream).sum();
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    private void createCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!checked[i][j] && arr[i][j] >= 2) {
                    clouds.add(new int[] {i, j});
                    arr[i][j] -= 2;
                }
            }
        }
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void waterIncrease() {
        int[][] tmp = new int[n][n];
        int len = clouds.size();
        for (int i = 0; i < len; i++) {
            int[] cloud = clouds.pollFirst();
            arr[cloud[0]][cloud[1]]++;
            clouds.add(cloud);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                tmp[i][j] = arr[i][j];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                checked[i][j] = false;
        }
        while (!clouds.isEmpty()) {
            int[] cloud = clouds.pollFirst();
            int cnt = 0;
            for (int i = 2; i <= 8; i += 2) {
                int y = cloud[0] + dy[i];
                int x = cloud[1] + dx[i];
                if (inRange(y, x) && arr[y][x] > 0)
                    cnt++;
            }
            tmp[cloud[0]][cloud[1]] += cnt;
            checked[cloud[0]][cloud[1]] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = tmp[i][j];
        }
    }
    private void move(int dir, int repeat) {
        int len = clouds.size();
        for (int i = 0; i < len; i++) {
            int[] cloud = clouds.pop();
            cloud[0] = (cloud[0] + (n + dy[dir]) * repeat) % n;
            cloud[1] = (cloud[1] + (n + dx[dir]) * repeat) % n;
            clouds.add(cloud);
        }
    }
}
