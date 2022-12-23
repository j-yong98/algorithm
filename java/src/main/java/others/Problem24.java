package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem24 {
    int n,m,k;
    int[][] arr;

    private void draw(int r){
        for (int i = k; i < k + m; i++){
            arr[r][i] = 1;
        }
        if (r == 0) return;
        for (int i = k; i < k + m; i++){
            arr[r-1][i] = 0;
        }
    }

    private boolean check(int r){
        for (int i = k; i < k + m; i++){
            if (arr[r][i] == 1) return true;
        }
        return false;
    }
    private boolean move(){
        for (int i = 0; i < n; i++){
            if (check(i)) return true;
            draw(i);
        }
        return false;
    }
    private void simulate(){
        move();
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken())-1;
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt +" ");
            }
            System.out.println();
        }
    }
}
