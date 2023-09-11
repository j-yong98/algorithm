package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    int N, M;
    int[] arr;

    /**
     * 주몽
     * 투포인터
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int ans = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == M) {
                ans += 1;
                l += 1;
                r -= 1;
            } else if (sum < M) l += 1;
            else r -= 1;
        }
        System.out.println(ans);
        br.close();
    }
}
