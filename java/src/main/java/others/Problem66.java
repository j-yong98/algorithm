package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem66 {
    int n;
    int[][] cost;
    int[] visited;
    int ans = Integer.MAX_VALUE;

    List<Integer> list = new ArrayList<>();

    /**
     * cost[s][e]가 0 이면 이동 불가이므로 -1 을 리턴
     */
    private int calc(){
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++){
            int c = cost[list.get(i)][list.get(i+1)];
            if (c == 0) return -1;
            res += c;
        }
        int c = cost[list.get(list.size()-1)][0];
        if (c == 0) return -1;
        return res + c;
    }
    private void f(int l){
        if (l == n){
            int res = calc();
            if (res == -1) return;
            ans = Math.min(ans,res);
            return;
        }
        for (int i = 0; i < n; i++){
            if (visited[i] == 1) continue;
            visited[i] = 1;
            list.add(i);
            f(l+1);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }

    /**
     * 1~n까지의 비용이 주어지고 1번부터 시작해 다시 1번으로 돌아오는 총 경비의 최솟값은?
     * @throws IOException
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = 1;
        list.add(0);
        f(1);
        System.out.println(ans);
    }
}
