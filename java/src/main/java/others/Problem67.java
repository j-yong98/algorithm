package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem67 {
    int n;
    int[][] arr;
    int[] visited;
    List<Integer> list = new ArrayList<>();
    int ans = 0;
    private void f(int l){
        if (l == n){
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                int v = arr[list.get(i)][i];
                if (v < value){
                    value = v;
                }
            }
            ans = Math.max(ans,value);
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
