package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1806 {
    int N, S;
    int[] arr;

    /**
     * 부분 합 
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = 0, r = 0;
        int sum = arr[l];
        int ans = Integer.MAX_VALUE;
        while (l < N) {

            if (sum < S) {
                if (r < N - 1) {
                    r++;
                    sum += arr[r];
                } else {
                    sum -= arr[l];
                    l++;
                }
            }
            else {
                ans = Math.min(ans, r - l + 1);
                sum -= arr[l];
                l++;
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
