package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem63 {
    int n,m;
    List<int[]> pos = new ArrayList<>();
    List<int[]> selected = new ArrayList<>();
    int ans = Integer.MAX_VALUE;

    private int dist(int y1, int x1, int y2, int x2){
        return (int) (Math.pow(y1-y2,2) + Math.pow(x1-x2,2));
    }
    private int calc(){
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++){
                res = Math.max(res,dist(selected.get(i)[0],selected.get(i)[1],selected.get(j)[0],selected.get(j)[1]));
            }
        }
        return res;
    }
    private void f(int l,int cnt){
        if (cnt == m){
            ans = Math.min(ans,calc());
            return;
        }
        if (l == n) {
            return;
        }
        f(l+1,cnt);
        selected.add(pos.get(l));
        f(l+1,cnt + 1);
        selected.remove(selected.size()-1);
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pos.add(new int[]{a,b});
        }
        f(0,0);
        System.out.println(ans);
        return ans;
    }
}
