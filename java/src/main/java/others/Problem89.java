package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem89 {
    final int MAX = 10000;
    int n,m;
    int[] arr;
    int[] dp;
    private void print(){
        for (int i = 1; i <= m; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    private void init(){
        for (int i = 0; i <= m; i++){
            dp[i] = MAX + 1;
        }
        dp[0] = 0;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init();
        for (int i = 0; i < n; i++){
            for (int j = m; j >= 1; j--){
                if (j < arr[i]) continue;
                dp[j] = Math.min(dp[j],dp[j - arr[i]] + 1);
            }
        }
        System.out.println(dp[m] == MAX + 1 ? "No" : "Yes");
    }
}
