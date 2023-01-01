package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem59 {
    int n, m;
    int[] arr;
    private void f(int s,int l){
        if (l == m){
            for (int i : arr) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }
        for (int i = s + 1; i <= n; i++){
            arr[l] = i;
            f(i,l+1);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        f(0,0);
    }
}
