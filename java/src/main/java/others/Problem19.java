package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem19 {
    int n, m, k;
    int[][] arr;

    private void fallDown() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == 0) continue;
                tmp[idx--][i] = arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }

    private void remove(int c, int s, int e) {
        for (int i = s; i > e; i--) {
            arr[i][c] = 0;
        }
    }

    private void boom(int c) {
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][c] == 0) continue;
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][c] != arr[j][c]) break;
                cnt++;
            }

            if (cnt >= m) {
                remove(c, i, i - cnt);
                fallDown();
                boom(c);
            }
        }
    }

    public int[][] rotate(int n, int[][] arr) {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        return arr;
    }

    private void rotate() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        fallDown();
    }
    public void print() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void explode() {
        for (int i = 0; i < n; i++) {
            boom(i);
        }
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= k; i++) {
            explode();
            rotate();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += Arrays.stream(arr[i]).filter(bomb -> bomb != 0).count();
        }
        System.out.println(cnt);
        return cnt;
    }
}
