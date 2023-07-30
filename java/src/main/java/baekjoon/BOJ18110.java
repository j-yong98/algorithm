package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ18110 {
    int n;
    int[] arr;
    /**
     * solved.ac
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);
        int p = (int) Math.round(((double) n) * 0.15);
        int sum = Arrays.stream(arr, p, n - p).sum();
        int avg = (int) Math.round((double) sum / (n - 2*p));
        System.out.println(avg);
        br.close();
    }
}
