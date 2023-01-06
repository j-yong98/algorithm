package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem81 {
    int n,m;
    int[][] arr;
    int[][] d;

    /**
     * NxM크기의 직사각형의 각 칸에 숫자가 적혀있다.
     * 해당 칸에서 최소 오른쪽 한 칸 이상 아래 한 칸 이상으로 점프를 뛸 수 있으며
     * 점프를 하고 난 후 위치의 숫자가 이전 숫자보다 커야한다.
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        d = new int[n][m];
        d[0][0] = 1;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                for (int k = 0; k < i; k++){
                    for (int l = 0; l < j; l++){
                        // 점프가 불가능한 위치라면 continue;
                        if (d[k][l] == 0) continue;
                        if (arr[i][j] > arr[k][l]){
                            d[i][j] = Math.max(d[i][j],d[k][l] + 1);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt());
        return Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt();
    }
}
