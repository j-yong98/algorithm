package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem91 {
    final int MAX_N = 100;
    final int MAX_M = 10_000;
    int n;
    int[] sticks = new int[MAX_N];
    int[] dp = new int[MAX_M + 1];
    private void print(){
        for (int i = 1; i <= n; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (j < i) continue;
                dp[j] = Math.max(dp[j],dp[j - i] + sticks[i]);
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}
