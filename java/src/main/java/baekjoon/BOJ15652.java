package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    int n,m;
    int[] arr;
    StringBuilder sb = new StringBuilder();
    private void comb(int d, int s) {
        if (d == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i <= n; i++){
            arr[d] = i;
            comb(d + 1, i);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        comb(0,1);
        System.out.println(sb.toString());
    }
}
