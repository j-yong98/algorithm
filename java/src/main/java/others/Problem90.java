package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem90 {
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
    Jewel[] arr = new Jewel[MAX_N];
    int[] dp = new int[MAX_M+1];
    private void print(){
        for (int i = 0; i <= m; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    /**
     * n개의 보석, 가방의 최대 넣을 수 있는 무게 m
     * 각 줄에 보석의 정보 weight 와 value가 주어진다. 가방에 담을 수 있는 최대 가치는?
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new Jewel(w,v);
        }
        for (int i = 0; i < n; i++){
            for (int j = m; j >= 0; j--){
                if (j < arr[i].w) continue;
                dp[j] = Math.max(dp[j],dp[j-arr[i].w] + arr[i].v);
            }
            print();
        }
        System.out.println(dp[m]);
        return dp[m];
    }
}
