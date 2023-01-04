package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem74 {
    int n;
    int[][] arr;
    int[][] d;
    private void init(){
        d[0][n-1] = arr[0][n-1];
        for (int i = n-2; i >= 0; i--){
            d[0][i] = d[0][i+1] + arr[0][i];
        }
        for (int i = 1; i < n; i++){
            d[i][n-1] = d[i-1][n-1] + arr[i][n-1];
        }
    }
    private void print(){
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        for (int i = 1; i < n; i++){
            for (int j = n-2; j >= 0; j--){
                d[i][j] = Math.min(d[i-1][j] + arr[i][j],d[i][j + 1] +arr[i][j]);
            }
        }
        System.out.println(d[n-1][0]);
        return d[n-1][0];
    }
}
