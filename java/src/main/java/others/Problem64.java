package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem64 {
    int n;
    int[] visited;
    int[] arr;
    private void f(int l){
        if (l == n){
            for (int i : arr) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }
        for (int i = n; i >= 1; i--){
            if (visited[i] == 0){
                visited[i] = 1;
                arr[l] = i;
                f(l+1);
                visited[i] = 0;
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new int[n+1];
        f(0);
    }
}
