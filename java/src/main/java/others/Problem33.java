package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem33 {
    int n,m,r,c;
    int[][] arr;
    int[][] tmp;

    int[] dy = {0,1,0,-1};
    int[] dx = {-1,0,1,0};
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private int getY(int i, int dist){
        return dy[i] * dist;
    }
    private int getX(int i, int dist){
        return dx[i] * dist;
    }
    private void bomb(int dist, int y, int x){
        for (int i = 0; i < 4; i++){
            int yy = y + getY(i,dist);
            int xx = x + getX(i,dist);
            if (!inRange(yy,xx) || arr[yy][xx] == 1) continue;
            tmp[yy][xx] = 1;
        }
    }
    private void copyArr(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tmp[i][j] = arr[i][j];
            }
        }
    }
    private void copyTmp(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }
    private void simulate(int t){
        copyArr();
        int dist = (int) Math.pow(2,t-1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 1){
                    bomb(dist,i,j);
                }
            }
        }
        copyTmp();
        print();
    }
    private void print(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 폭탄이 r,c위치에 하나 있고 m초가 지날 때 최종 폭탄의 수
     * 1초가 지날 때 마다 폭탄은 2^t-1 위치에 추가된다.
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n][n];
        tmp = new int[n][n];
        arr[r][c] = 1;

        for (int i = 1; i <= m; i++){
            simulate(i);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++){
            cnt += Arrays.stream(arr[i]).filter(s -> s != 0).sum();
        }
        System.out.println(cnt);
        return cnt;
    }
}
