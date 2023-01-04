package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem75 {
    int n;
    int[][] arr;
    int[][] d;

    private void init() {
        d[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(arr[i][0],d[i-1][0]);
            d[0][i] = Math.min(arr[0][i],d[0][i-1]);
        }
    }
    private void print(int[][] d){
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * NxN행렬이 있을 때 1,1에서 출발하여 n,n으로 오른쪽 혹은 아래로만 이동이 가능하다 할 때 거처간 숫자들 중 최솟값 중 최댓값은?
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] = Math.max(Math.min(d[i-1][j],arr[i][j]),Math.min(d[i][j-1],arr[i][j]));
            }
        }
        System.out.println(d[n-1][n-1]);
        return d[n-1][n-1];
    }
}
