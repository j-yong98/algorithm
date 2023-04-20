package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17822 {
    int n, m, t;
    int[][] arr;

    /**
     * 원판 돌리기
     * float 계산 주의
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            simulate(x, d, k);
        }
        System.out.println(Arrays.stream(arr).flatMapToInt(Arrays::stream).sum());
        return Arrays.stream(arr).flatMapToInt(Arrays::stream).sum();
    }
    private void simulate(int x, int d, int k) {
        for (int i = x; i <= n; i += x) {
            rotate(i, d, k);
        }
        search();
    }
    private void rotate(int idx, int d, int k) {
        if (d == 0) {
            for (int i = 0; i < k; i++) {
                int tmp = arr[idx][m - 1];
                for (int j = m - 1; j >= 1; j--)
                    arr[idx][j] = arr[idx][j - 1];
                arr[idx][0] = tmp;
            }

        }
        else {
            for (int i = 0; i < k; i++) {
                int tmp = arr[idx][0];
                for (int j = 0; j < m - 1; j++)
                    arr[idx][j] = arr[idx][j + 1];
                arr[idx][m - 1] = tmp;
            }
        }
    }
    private void search() {
        List<int[]> removeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                if (i < n && arr[i][j] == arr[i + 1][j]) {
                    removeList.add(new int[]{i, j});
                    removeList.add(new int[]{i + 1, j});
                }
                if (arr[i][j] == arr[i][(j + 1) % m]) {
                    removeList.add(new int[]{i, j});
                    removeList.add(new int[]{i, (j + 1) % m});
                }
                if (arr[i][j] == arr[i][(j - 1 + m) % m]) {
                    removeList.add(new int[]{i, j});
                    removeList.add(new int[]{i, (j - 1 + m) % m});
                }
            }
        }
        if (removeList.size() == 0) {
            int cnt = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0)
                        continue;
                    sum += arr[i][j];
                    cnt++;
                }
            }
            float res = (float)sum / (float)cnt;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) continue;
                    if ((float)arr[i][j] > res)
                        arr[i][j]--;
                    else if ((float)arr[i][j] < res)
                        arr[i][j]++;
                }
            }
        }
        else {
            for (int i = 0; i < removeList.size(); i++) {
                int[] pos = removeList.get(i);
                if (arr[pos[0]][pos[1]] == 0)
                    continue ;
                arr[pos[0]][pos[1]] = 0;
            }
        }
    }
}
