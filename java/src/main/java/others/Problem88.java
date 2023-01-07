package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem88 {
    final int MAX_N = 100;
    final int MAX_M = 10_000;
    final int MAX_COIN = 10_000;
    int n,m;
    int[] coins = new int[MAX_N+1];
    int[] d = new int[MAX_M+1];
    private void print(){
        for (int i = 1; i <= m; i++){
            System.out.print(d[i]+" ");
        }
        System.out.println();
    }

    /**
     * 최대 동전 거슬러주기
     * n개의 동전이 있을 때 m을 거슬러 주기 위한 방법 중 최대 동전 수를 구하라
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
            d[coins[i]] = 1;
        }
        for (int i = 1; i <=m; i++){
            for (int j = 0; j < n; j++){
                if (i <= coins[j] || d[i-coins[j]] == 0) continue;
                d[i] = Math.max(d[i], d[i - coins[j]] + 1);
            }
            print();
        }
        System.out.println(d[m] == 0 ? -1 : d[m]);
        return d[m] == 0 ? -1 : d[m];
    }
}
