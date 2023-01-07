package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11054 {
    final int MAX = 1000;
    int n;
    int[] arr;
    int[][] dp = new int[2][MAX+1];
    private void print(){
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                System.out.print(dp[k][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
            dp[1][i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
                if (arr[i] < arr[j]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
            dp[1][i] = Math.max(dp[1][i], dp[0][i]);
            print();
        }
        System.out.println(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt());
    }
}
