package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    /**
     * 설탕 배달
     * dp 활용 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 6];
        arr[3] = 1;
        arr[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (i % 5 == 0)
                arr[i] = arr[i - 5] + 1;
            else if (i % 3 == 0)
                arr[i] = arr[i - 3] + 1;
            else {
                if (arr[i - 5] == 0 && arr[i - 3] == 0) continue;
                arr[i] = Math.min(arr[i - 5], arr[i - 3]) + 1;
            }
        }
        System.out.println(arr[n] == 0 ? -1 : arr[n]);
    }
}
