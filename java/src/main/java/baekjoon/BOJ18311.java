package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18311 {
    int N;
    long K;
    long[] arr;

    /**
     * 왕복
     * 더했을 때 오버플로우 생각!
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long sum = Arrays.stream(arr, 1, N + 1).sum();
        if (K > sum) {
            K = K - sum;
            for (int i = N; i > 0; i--) {
                if (K - arr[i] < 0) {
                    sb.append(i);
                    break;
                }
                K -= arr[i];
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (K - arr[i] < 0) {
                    sb.append(i);
                    break;
                }
                K -= arr[i];
            }
        }
        System.out.println(sb);
        br.close();
    }
}
