package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem77 {
    int n;
    int[][] arr;
    int[][] d;

    private void init() {
        d[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(d[i - 1][0], arr[i][0]);
            d[0][i] = Math.max(d[0][i - 1], arr[0][i]);
        }
    }
    private void print(){
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                d[i][j] = Math.min(Math.max(arr[i][j],d[i-1][j]),Math.max(arr[i][j],d[i][j-1]));
            }
        }
        System.out.println(d[n-1][n-1]);
    }
}
