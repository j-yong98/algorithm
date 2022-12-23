package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11 {
    private int n,m,Q;
    private int[][] arr;

    /**
     * 직사각형 주변부만 회전
     */
    private void rotate(int r1, int c1, int r2, int c2){
        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};
        int pre = arr[r1][c1];
        int y = r1;
        int x = c1;
        int i = 0;
        while (true){
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy,xx,r1,c1,r2,c2)){
                i++;
            }
            else{
                if (yy == r1 && xx == c1) break;
                int tmp = arr[yy][xx];
                arr[yy][xx] = pre;
                pre = tmp;
                y = yy;
                x = xx;
            }
        }
        arr[r1][c1] = pre;
    }
    private boolean inRange(int y, int x, int r1, int c1, int r2, int c2){
        return y >= r1 && y <= r2 && x >= c1 && x <= c2;
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    /**
     * 주변 값의 평균으로 배열값 변경. 새로운 배열을 선언하여 옮기자.
     */
    private void changeAvg(int r1, int c1, int r2, int c2){
        int[] dy = {0,1,0,-1};
        int[] dx = {-1,0,1,0};

        int[][] copy = new int[n][m];

        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                int cnt = 1;
                int sum = arr[i][j];
                for (int k = 0; k < 4; k++){
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (inRange(y,x)){
                        cnt++;
                        sum += arr[y][x];
                    }
                }
                copy[i][j] = sum / cnt;
            }
        }

        for (int i = r1; i<=r2; i++){
            for (int j = c1; j<=c2; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    public int[][] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int q = 0; q < Q; q++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            rotate(r1,c1,r2,c2);
            changeAvg(r1,c1,r2,c2);
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        return arr;
    }
}
