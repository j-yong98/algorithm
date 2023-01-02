package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem65 {
    int n;
    int[][] arr;
    int[] visited;

    List<Integer> list = new ArrayList<>();
    int ans = 0;

    private void f(int l){
        if (l == n){
            int res = 0;
            for (int i = 0; i < n; i++){
                res += arr[i][list.get(i)];
            }
            ans = Math.max(ans,res);
            return;
        }
        for (int i = 0; i < n; i++){
            if (visited[i] == 0) {
                visited[i] = 1;
                list.add(i);
                f(l+1);
                visited[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 각 행과 열에 정확히 한 개의 색칠 칸만 오도록 이런 합들 중 최댓값은?
     * @throws IOException
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0);
        System.out.println(ans);
    }
}
