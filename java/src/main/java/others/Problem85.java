package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem85 {
    final int MAX = 10_000;
    int n,m;
    int[] coins;
    int[] d = new int[MAX + 1];
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        d[0] = 0;
        for (int i = 1; i <= m; i++){
            d[i] = Integer.MAX_VALUE - 1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int coin = Integer.parseInt(st.nextToken());
            d[coin] = 1;
            coins[i] = coin;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 0; j < n; j++){
                if (i <= coins[j]) continue;
                d[i] = Math.min(d[i],d[i-coins[j]] + 1);
            }
        }
        System.out.println(d[m] == Integer.MAX_VALUE ? -1 : d[m]);
        return d[m] == Integer.MAX_VALUE ? -1 : d[m];
    }
}
