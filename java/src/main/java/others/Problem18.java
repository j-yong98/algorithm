package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18 {
    int n, m;
    int[][] arr;

    private int findRow(int c) {
        for (int i = 0; i < n; i++) {
            if (arr[i][c] != 0) return i;
        }
        return -1;
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void boom(int c) {
        int r = findRow(c);
        if (r == -1) {
            return;
        }
        int range = arr[r][c] - 1;
        for (int i = r - range; i <= r + range; i++) {
            if (!inRange(i,c)) continue;
            arr[i][c] = 0;
        }
        for (int i = c - range; i <= c + range; i++) {
            if (!inRange(r,i)) continue;
            arr[r][i] = 0;
        }
    }

    private void fallDown(){
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++){
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--){
                if (arr[j][i] == 0) continue;
                tmp[idx--][i] = arr[j][i];
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()) - 1;
            boom(c);
            fallDown();
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
