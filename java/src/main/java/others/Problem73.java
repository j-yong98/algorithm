package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem73 {
    int n;
    int[][] arr;
    int[][] d;
    private void dp(){
        d[0][0] = arr[0][0];
        for (int i = 1; i < n; i++){
            d[i][0] = d[i-1][0] + arr[i][0];
            d[0][i] = d[0][i-1] + arr[0][i];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                d[i][j] = Math.max(d[i-1][j] + arr[i][j], d[i][j-1] + arr[i][j]);
            }
        }
    }

    /**
     * NxN행렬이 주어졌을 때 1,1에서 출발해 n,n으로 간다 했을 때 거쳐간 위치의 숫자 합의 최댓값은?
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp();
        System.out.println(d[n-1][n-1]);
        return d[n-1][n-1];
    }
}
