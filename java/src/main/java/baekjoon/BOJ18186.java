package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18186 {
    int N;
    long B, C;
    long[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        if (B < C) {
            for (int i = 0; i < N; i++)
                ans += arr[i] * B;
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                long cost = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                ans += cost * (B + C);
                arr[i] -= cost;
                arr[i + 1] -= cost;

                cost = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cost * (B + 2 * C);
                arr[i] -= cost;
                arr[i + 1] -= cost;
                arr[i + 2] -= cost;
            } else {
                long cost = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cost * (B + 2 * C);
                arr[i] -= cost;
                arr[i + 1] -= cost;
                arr[i + 2] -= cost;

                cost = Math.min(arr[i], arr[i + 1]);
                ans += cost * (B + C);
                arr[i] -= cost;
                arr[i + 1] -= cost;
            }
            ans += arr[i] * B;
        }
        System.out.println(ans);
    }
}
