package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    int N;
    int[] arr;
    boolean[] checked;

    /**
     * 좋다
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        checked = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = N - 1;
            while (l < r) {
                if (l == i) {
                    l += 1;
                    continue;
                }
                else if (r == i) {
                    r -= 1;
                    continue;
                }

                int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    ans += 1;
                    break;
                } else if (sum < arr[i]) l += 1;
                else r -= 1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
