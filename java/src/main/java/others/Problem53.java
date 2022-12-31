package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem53 {
    int n, m, c;
    int[][] arr;
    int[] tmp;
    int max;


    private void f(int l, int w, int s) {
        if (l == m){
            if (w <= c){
                max = Math.max(max,s);
            }
            return;
        }
        f(l+1,w,s);
        f(l+1,w+tmp[l],s+tmp[l]*tmp[l]);
    }

    private int findMax(int r, int c){
        for (int i = c; i < c + m; i++){
            tmp[i-c] = arr[r][i];
        }
        max = 0;
        f(0,0,0);
        return max;
    }
    private boolean intersect(int c1,int c2, int c3,int c4){
        return !(c2 < c3 || c4 < c1);
    }
    private boolean isPossible(int r1, int c1, int r2, int c2){
        if (c1 + m - 1 >= n || c2 + m - 1 >= n) return false;
        if (r1 != r2) return true;
        if (intersect(c1,c1+m-1,c2,c2+m-1)) return false;

        return true;
    }

    /**
     * NxN 크기의 방에서 두명의 도둑이 연속된 m개의 열에서 물건을 훔칠 수 있다.
     * 두 도둑은 같은 행을 고를 수 있지만 선택한 m개가 겹치면 안된다.
     * 보물의 가치는 보물의 무게 * 무게이다.
     * 훔치는 최대 보물의 가치는 ?
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        tmp = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    for (int l = 0; l < n; l++){
                        if (isPossible(i,j,k,l)){
                           ans = Math.max(ans, findMax(i,j)+findMax(k,l));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
