package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem108 {
    int T;
    int n;
    int[][] arr;
    /**
     * 파스칼의 삼각형
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            System.out.println("#" + t);
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i][1] = 1;
                arr[i][i] = 1;
            }
            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++)
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=i; j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
}
