package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9 {
    private final int MAX = 45;
    int n;
    int[] arr = new int[MAX+1];
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]);
        return arr[n];
    }
}
