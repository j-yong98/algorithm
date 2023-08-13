package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1758 {
    int N;
    int[] arr;
    long ans = 0;
    /**
     * 알바생 강호
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i = N - 1; i >= 0; i--) {
            int tip = arr[i] - (N - i - 1);
            if (tip <= 0) break;
            ans += tip;
        }
        System.out.println(ans);
        br.close();
    }
}
