package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4 {

    int n,m;
    int[][] arr;

    private int getGold(int k,int y, int x) {
        int gold = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                    if (Math.abs(i - y) + Math.abs(j - x) <= k) {
                        gold += arr[i][j];
                    }
            }
        }

        return gold;
    }

    private int getArea(int k){
        return k * k + (k+1) * (k+1);
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
                for (int k = 0; k <= 2 * (n-1); k++){
                    int gold = getGold(k, i, j);

                    if (gold * m >= getArea(k)){
                        ans = Math.max(ans,gold);
                    }
                }
            }
        }
        return ans;
    }
}
