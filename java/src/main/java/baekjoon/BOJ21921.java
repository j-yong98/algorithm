package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    /**
     * 블로그
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            arr[i] += arr[i - 1];
        int max = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i < x) continue;
            int tmp = arr[i] - arr[i - x];
            if (tmp > max) {
                max = tmp;
                cnt = 1;
            } else if (tmp == max) {
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (max == 0) sb.append("SAD");
        else sb.append(max).append("\n").append(cnt);
        System.out.println(sb);
    }
}
