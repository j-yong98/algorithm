package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem92 {
    class Jewel{
        int w;
        int v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    final int MAX_N = 100;
    final int MAX_M = 10_000;
    int n,m;
    Jewel[] jewels = new Jewel[MAX_N];
    int[] dp = new int[MAX_M + 1];
    private void print(){
        for (int i = 1; i <= m; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w,v);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= m; j++){
                if (j < jewels[i].w) continue;
                dp[j] = Math.max(dp[j],dp[j - jewels[i].w] + jewels[i].v);
            }
        }
        System.out.println(dp[m]);
        return dp[m];
    }
}
