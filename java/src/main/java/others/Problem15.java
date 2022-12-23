package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15 {

    private int n;
    private int[][] arr;
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void boom(int r, int c){
        int score = arr[r][c]-1;
        for (int i = r - score; i <= r + score; i++){
            if (inRange(i,c)){
                arr[i][c] = 0;
            }
        }
        for (int i = c - score; i <= c+score; i++){
            if (inRange(r,i)){
                arr[r][i] = 0;
            }
        }
    }
    private void fall(){
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++){
            int idx = n-1;
            for (int j = n-1; j >= 0; j--){
                if (arr[j][i] != 0){
                    tmp[idx--][i] = arr[j][i];
                }
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
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        boom(r,c);
        fall();
        print();
    }

    private void print() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
