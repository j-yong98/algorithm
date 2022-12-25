package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem31 {
    int n;
    int[] ans;
    int res;
    private void recursion(int l){
        if (l == n){
            int cnt = 1;
            for (int i = 1; i < n; i++){
                if (ans[i-1] == ans[i]) {
                    cnt++;
                    continue;
                }
                if (cnt % ans[i-1] != 0) return;
                cnt = 1;
            }
            if (cnt % ans[n-1] != 0) return;
            res++;
            for (int an : ans) {
                System.out.print(an+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 4; i++){
            ans[l] = i;
            recursion(l+1);
        }
    }

    /**
     *  아름다운 수 - 1~4로 이루어진 n자리 수 각 자리의 수가 각 자리의 수만큼 연속 되고 반복되는 수
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        res = 0;
        ans = new int[n];
        recursion(0);
        System.out.println(res);
        return res;
    }
}
