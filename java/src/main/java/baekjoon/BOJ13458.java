package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {
    int n;
    int b, c;
    int[] arr;
    long ans = 0;

    /**
     * 시험 감독
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            ans++;
            arr[i] -= b;
            if (arr[i] <= 0) continue;
            if (arr[i] % c == 0) ans = ans + (arr[i] / c);
            else ans = ans + (arr[i] / c + 1);
        }
        System.out.println(ans);
    }
}
