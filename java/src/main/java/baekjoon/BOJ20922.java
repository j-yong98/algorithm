package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
    final int MAX = 100_000;
    int N, K;
    int[] arr;
    int[] count = new int[MAX + 1];

    /**
     * 겹치는 건 싫어
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, ans = 0;
        count = new int[MAX + 1];
        while (r < N) {
            if (count[arr[r]] != K)
                count[arr[r++]]++;
            else
                count[arr[l++]]--;
            ans = Math.max(ans, r - l);
        }
        System.out.println(ans);
    }
}
