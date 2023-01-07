package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem87 {
    final int MAX = 1000;
    int n;
    int[] d = new int[MAX + 1];
    int[] arr = {1,2,5};
    int ans = 0;
    private void print(){
        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++){
                if (i < arr[j]) continue;
                d[i] = (d[i] + d[i-arr[j]]) % 10007;
            }
            print();
        }
        System.out.println(d[n]);
        return d[n];
    }
}
