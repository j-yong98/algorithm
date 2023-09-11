package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    int N, K;
    int[] arr;

    /**
     * 수열
     * 투포인터 유형
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += arr[i];
        int ans = sum;
        int l = 0;
        int r = K - 1;
        while (r < N - 1) {
            sum += arr[++r];
            sum -= arr[l++];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
        br.close();
    }
}
