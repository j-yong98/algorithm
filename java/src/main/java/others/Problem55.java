package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem55 {
    int n,m,k;
    int[] score;
    int[] arr;
    int ans = 0;
    private int getCnt(){
        int cnt = 0;
        for (int i = 0; i < k; i++){
            if (score[i] >= m) cnt++;
        }
        return cnt;
    }
    private void f(int l){
        if (l == n){
            ans = Math.max(ans,getCnt());
            return;
        }
        for (int i = 0; i < k; i++){
            score[i] += arr[l];
            f(l+1);
            score[i] -= arr[l];
        }
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        score = new int[k];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++){
            score[i] = 1;
        }
        f(0);
        System.out.println(ans);
        return ans;
    }
}
