package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem84 {
    int n;
    int[] arr;
    int[][] d;

    /**
     * n개의 숫자가 주어진다. 가장 긴 증가-감소 수열의 길이를 구하라.
     * 단, 처음부터 끝까지 증가만 하거나 감소만 하는 부분수열 역시 증가 - 감소 수열의 부분수열임을 유의하자
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        d = new int[2][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++){
            d[0][i] = 1;
            d[1][i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    d[0][i] = Math.max(d[0][i],d[0][j]+1);
                }
                if (arr[i] < arr[j]){
                    d[1][i] = Math.max(d[1][i],d[1][j]+1);
                }
            }
            // 증가하던 것을 멈추고, 감소하는 것으로 방향을 옮긴다.
            d[1][i] = Math.max(d[0][i],d[1][i]);
        }

        System.out.println(Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt());
        return Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt();
    }
}
