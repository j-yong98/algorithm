package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15565 {
    int N, K;
    int[] arr;

    /**
     * 귀여운 라이언
     * 투포인터 풀이
     * 맨처음 원소 2개를 고른 뒤 K개수 만큼 고르면 l을 이동시키고 작으면 r을 이동시켜 범위를 넓혀준다.
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
        int cnt = 0;
        int l, r;
        l = r = 0;
        if (arr[l] == 1) cnt++;
        int ans = Integer.MAX_VALUE;
        while (N - l > K) {
            if (cnt >= K) {
                ans = Math.min(ans, r - l + 1);
                if (arr[l] == 1) cnt--;
                l++;
            } else {
                if (r < N - 1) {
                    r++;
                    if (arr[r] == 1) cnt++;
                } else {
                    if (arr[l] == 1) cnt--;
                    l++;
                }
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
