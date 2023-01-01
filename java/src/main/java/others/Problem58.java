package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem58 {
    int n;
    int[] arr;
    int ans = Integer.MAX_VALUE;
    private void f(int pos,int cnt){
        if (pos >= n) return;
        if (pos == n - 1) {
            ans = Math.min(ans,cnt);
            return;
        }
        for (int i = 1; i <= arr[pos]; i++){
            f(pos+i,cnt+1);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        f(0,0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
