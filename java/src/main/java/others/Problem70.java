package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem70 {
    final int MAX = 1000;
    final int MOD = 1_000_000_007;
    int n;
    long[] arr = new long[MAX + 1];
    public long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr[0] = 1;
        arr[1] = 2;
        /**
         * d[i-1] * 2 + d[i-2] * 3 + 2 * (d[i-3]+ ... + d[0])
         */
        for (int i = 2; i <= n; i++){
            arr[i] = (arr[i - 1] * 2 + arr[i-2] * 3) % MOD;
            for (int j = i - 3; j >= 0; j--){
                arr[i] = (arr[i] + arr[j] * 2) % MOD;
            }
        }
        System.out.println(arr[n]);
        return arr[n];
    }
}
