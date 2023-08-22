package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    final int MAX = 1_000_000_001;
    int N;
    int[] arr;

    /**
     * 두 용액
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int[] two = new int[]{MAX, MAX};
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == 0) {
                System.out.println(arr[l] + " " + arr[r]);
                return;
            } else if (Math.abs(two[0] + two[1]) > Math.abs(sum)) {
                two[0] = arr[l];
                two[1] = arr[r];
            }
            if (sum < 0)
                l += 1;
            else
                r -= 1;
        }
        System.out.println(two[0] + " " + two[1]);
    }

}
