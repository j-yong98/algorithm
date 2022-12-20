import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4 {

    int n,m;
    int[][] arr;

    private void print(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println();
    }
    private boolean inRange(int y, int x, int size){
        return y >= 0 && y < size && x >= 0 && x < size;
    }
    private int[][] makeMap(int c){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int size = c*2+1;
        int[][] arr2 = new int[size][size];
        arr2[size/2][size/2] = 1;
        for (int k = 0; k < c; k++){
            int[][] copy = new int[size][size];
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (arr2[i][j] == 1){
                        copy[i][j] = 1;
                        for (int l = 0; l < 4; l++){
                            int y = i + dy[l];
                            int x = j + dx[l];
                            if (inRange(y,x,size) && arr2[y][x] == 0){
                                copy[y][x] = 1;
                            }
                        }
                    }
                }
            }
            arr2 = copy;
        }
        return arr2;
    }
    private int getGold(int k,int y, int x) {
        int[][] map = makeMap(k);
        int cnt = 0;
        for (int i = 0; i < k*2+1; i++){
            for (int j = 0; j < k*2+1; j++){
                if (map[i][j] == 0) continue;
                else if (!inRange(y+i,x+j,n)) return 0;
                else if (arr[y+i][x+j] == 1) cnt++;
            }
        }
        int gold = cnt * m;
        int mining = k * k + (k+1) * (k+1);
        return gold - mining;
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
        for (int k = 0; k <= n / 2; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    ans = Math.max(ans,getGold(k,i,j));
                }
            }
        }
        return ans;
    }
}
