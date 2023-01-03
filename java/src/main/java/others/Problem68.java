package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem68 {
    final int MAX = 1000;
    int n;
    int[] arr = new int[MAX + 1];
    int ans = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= n; i++){
            arr[i] = (arr[i-2] + arr[i-3])% 10_007;
        }
        System.out.println(arr[n]);
    }
}
