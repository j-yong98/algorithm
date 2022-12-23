package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {

    static final int SIZE = 3;
    static int n;
    static int[][] arr;
    private static int check(int r, int c){
        int cnt = 0;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j <SIZE; j++){
                if (arr[r+i][c+j] == 1) cnt++;
            }
        }
        return cnt;
    }
    public int exhaustive() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= n-SIZE; i++){
            for (int j = 0; j <= n-SIZE; j++){
                ans = Math.max(ans,check(i,j));
            }
        }
        System.out.println(ans);
        return ans;
    }
}
