package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
    final int BLANK = 0;
    final int CHEESE = 1;
    final int MELT = 2;
    final int AIR = 3;
    final int DIR = 4;
    int r,c;
    int[][] arr;
    int time = 0;
    int remainCheese = 0;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};

    private boolean inRange(int y, int x){
        return y >= 0 && y < r && x >= 0 && x < c;
    }
    private boolean isMelt(int y, int x){

        for (int i = 0; i < DIR; i++){
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy,xx) && arr[yy][xx] == AIR) return true;
        }
        return false;
    }
    private void markMeltingCheese() {
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (arr[i][j] == CHEESE && isMelt(i,j)) arr[i][j] = MELT;
            }
        }
    }
    private boolean allMelt(){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (arr[i][j] == CHEESE) return false;
            }
        }
        return true;
    }
    private void print(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void melt(){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (arr[i][j] == MELT) arr[i][j] = BLANK;
            }
        }
    }
    private void countCheese(){
        remainCheese = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (arr[i][j] == CHEESE) remainCheese++;
            }
        }
    }
    private void markAir(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < DIR; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x) && arr[y][x] == BLANK) {
                    q.add(new int[]{y,x});
                    arr[y][x] = AIR;
                }
            }
        }
    }
    private void markBlank(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < DIR; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x) && arr[y][x] == AIR) {
                    q.add(new int[]{y,x});
                    arr[y][x] = BLANK;
                }
            }
        }
    }
    private void simulate(){
        countCheese();
        markAir();
        markMeltingCheese();
        melt();
        markBlank();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            if(allMelt()) break;
            ++time;
            simulate();
        }
        System.out.println(time);
        System.out.println(remainCheese);
        return time;
    }
}
