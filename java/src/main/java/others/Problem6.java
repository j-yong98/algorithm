package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6 {

    int n;
    int[][] arr;

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private int getSum(int y, int x,int k, int l){
        int[] dy = {-1,-1,1,1};
        int[] dx = {1,-1,-1,1};
        int[] length = {k,l,k,l};
        int sum = 0;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < length[i]; j++){
                int yy = y + dy[i];
                int xx = x + dx[i];
                if (!inRange(yy,xx)) return 0;
                sum += arr[yy][xx];
                y += dy[i];
                x += dx[i];
            }
        }

        return sum;
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 1; k < n; k++){
                    for (int l = 1; l < n; l++){
                        int sum = getSum(i, j, k, l);

                        ans = Math.max(ans,sum);
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
