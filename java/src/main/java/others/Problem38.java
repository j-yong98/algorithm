package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem38 {
    int n,m,t;
    int[][] arr;
    int[][] bead;
    int[][] copy;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};

    private void beadToCopy(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                copy[i][j] = bead[i][j];
            }
        }
    }
    private void copyToBead(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                bead[i][j] = copy[i][j];
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void move(int y, int x){
        int max = 0;
        int cy = -1;
        int cx = -1;
        for (int i = 0; i < 4; i++){
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy,xx) && max < arr[yy][xx]){
                max = arr[yy][xx];
                cy = yy;
                cx = xx;
            }
        }
        if (cy != -1 && cx != -1){
            copy[y][x] -= 1;
            copy[cy][cx] += 1;
        }
    }
    private void isCollide(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (copy[i][j] > 1){
                    copy[i][j] = 0;
                }
            }
        }
    }
    private void print(){
        for (int[] ints : bead) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void simulate(){
        beadToCopy();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (bead[i][j] == 1){
                    move(i,j);
                }
            }
        }
        isCollide();
        copyToBead();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        bead = new int[n][n];
        copy = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            bead[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        for (int i = 0; i < t; i++){
            simulate();
        }
        int cnt = Arrays.stream(bead).flatMapToInt(Arrays::stream).filter(i -> i != 0).sum();
        System.out.println(cnt);
        return cnt;
    }
}
