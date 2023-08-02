package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16112 {
    long n, m;
    long[] arr;

    /**
     * 5차 전직
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new long[(int)n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += (arr[i] * Math.min(i, m));
        System.out.println(sum);
    }
}
