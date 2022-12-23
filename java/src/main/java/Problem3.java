import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
    int n,m;
    int[][] arr;

    /**
     * block 1
     * (y + 1, x) (y, x + 1),
     * (y - 1, x) (y, x + 1),
     * (y - 1, x) (y, x - 1),
     * (y + 1, x) (y, x - 1)
     *
     * block 2
     * (y, x - 1) (y, x + 1)
     * (y - 1, x) (y + 1, x)
     */
    private boolean inRange(int r, int c){
        return r >= 0 &&  r < n && c >= 0 && c < m;
    }
    private int getMaxSum(int r,int c){
        int sum = 0;
        int[] dy = {1,-1,-1,1};
        int[] dx = {1,1,-1,-1};

        for (int i = 0; i < 4; i++){
            int y1 = r + dy[i];
            int x1 = c;
            int y2 = r;
            int x2 = c + dx[i];
            if (inRange(y1,x1) && inRange(y2,x2)){
                sum = Math.max(sum, arr[r][c] + arr[y1][x1] + arr[y2][x2]);
            }
        }

        if (inRange(r+1,c) && inRange(r-1,c)){
            sum = Math.max(sum, arr[r][c] + arr[r+1][c] + arr[r-1][c]);
        }
        if (inRange(r,c+1) && inRange(r,c-1)){
            sum = Math.max(sum, arr[r][c] + arr[r][c+1] + arr[r][c-1]);
        }
        return sum;
    }

    public int solution() throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                ans = Math.max(ans,getMaxSum(i,j));
            }
        }
        return ans;
    }
}
