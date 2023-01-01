package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem60 {
    int n,m;
    int[] arr;
    int[] selected;
    int ans = 0;
    private void f(int s, int l){
        if (l == m){
            int res = selected[0];
            for (int i = 1; i < m; i++){
                res ^= selected[i];
            }
            ans = Math.max(ans,res);
            return;
        }
        for (int i = s; i < n; i++){
            selected[l] = arr[i];
            f(i+1,l+1);
        }
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        f(0,0);
        System.out.println(ans);
        return ans;
    }
}
