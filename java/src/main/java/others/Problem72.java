package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem72 {
    final int MAX = 1000;
    int n;
    int[] d = new int[MAX + 1];
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d[0] = 1;
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++){
            d[i] = (d[i-1] + d[i-2] * 2) % 10_007;
        }
        System.out.println(d[n]);
        return d[n];
    }
}
