package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20 {
    int n;
    int[][] arr;
    int[][] copy;

    private void arrToCopy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }
    private int getMaxPair() {
        int[] dy = {0,1,0,-1};
        int[] dx = {-1,0,1,0};
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (copy[i][j] == 0) continue;
                for (int k = 0; k < 4; k++){
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (inRange(y,x)){
                        if (copy[i][j] == copy[y][x]) cnt++;
                    }
                }
                copy[i][j] = 0;
            }
        }
        return cnt;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private void print() {
        for (int[] ints : copy) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void explode(int r, int c) {
        int range = arr[r][c] - 1;
        for (int i = r - range; i <= r + range; i++) {
            if (inRange(i, c)) copy[i][c] = 0;
        }
        for (int j = c - range; j <= c + range; j++) {
            if (inRange(r, j)) copy[r][j] = 0;
        }
    }

    private void fallDown() {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (copy[j][i] == 0) continue;
                tmp[idx--][i] = copy[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = tmp[i][j];
            }
        }
    }

    private int simulate() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrToCopy();
                explode(i, j);
                fallDown();
                ans = Math.max(ans, getMaxPair());
            }
        }
        return ans;
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = simulate();
        System.out.println(ans);
        return ans;
    }
}
