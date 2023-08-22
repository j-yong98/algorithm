package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    int N, K;
    int[] arr;

    /**
     * 두 수의 합
     * 투 포인터 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 0;
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == K)
                ans++;
            if (sum < K)
                l++;
            else
                r--;
        }
        System.out.println(ans);
    }
}
