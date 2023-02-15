package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem97 {
    class clothes {
        int s;
        int e;
        int v;

        public clothes(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
    final int MIN = -5000;
    int n, m;
    clothes[] arr;
    int[][] dp;
    public void init(){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = MIN;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new clothes[n];
        dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new clothes(s,e,v);
        }
        init();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i - 1 >= arr[k].s && i - 1 <= arr[k].e && i >= arr[j].s && i <= arr[j].e)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(arr[k].v - arr[j].v));
                }
            }
        }
        System.out.println(Arrays.stream(dp[m-1]).max().getAsInt());
    }
    /**
     * n개의 옷에서 하루에 한 개의 옷을 선택하여 m일 입었을 때 최고의 만족도를 구하는 문제이다.
     * m일동안 옷을 입을 때 전날 입었던 옷을 입을 수 있다.
     * 고려해야 될 사항으로는 오늘 입을 옷, 지금까지 만족도, 지금까지 입을 옷을 고려한 날짜 세가지이다
     * 3중 for 문을 사용했는데 i는 현재까지 날짜를 의미하고
     * j는 오늘 입을 옷의 번호
     * k는 어제 입은 옷의 번호이다.
     * 만족도는 어제입은 옷의 value - 오늘 입을 옷의 value이다.
     * 어제까지 입은 옷의 만족도는 dp[i-1][k]이다.
     * 오늘까지 입은 옷의 만족도는 dp[i-1][k] + abs(k.v - j.v)가 된다.
     * 직전날 k번째 옷을 입었을 때의 만족도를 memorization하여 오늘 입을 옷의 value와 계산하여 풀이하였다.
     */
}
