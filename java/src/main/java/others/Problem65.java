package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem65 {
    int n;
    int[][] arr;
    int[][] visited;
    int ans = 0;

    private void f(int l,int sum){
        if (l == n){
            ans = Math.max(ans,sum);
            return;
        }
        for (int i = l; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[0][i] == 0 && visited[1][j] == 0){
                    visited[0][i] = 1;
                    visited[1][j] = 1;
                    f(l+1,sum + arr[i][j]);
                    visited[0][i] = 0;
                    visited[1][j] = 0;
                }
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[2][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0,0);
        System.out.println(ans);
    }
}
