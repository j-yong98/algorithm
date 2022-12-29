package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Pos{
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Problem49 {
    int n;
    int[][] arr;
    List<Pos> list;
    int[] bombNum;
    int ans;

    private void init(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = 0;
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && arr[y][x] == 0;
    }
    private int[] getBombSizeY(int kinds){
        if (kinds == 1){
            return new int[]{-2,-1,1,2};
        }
        if (kinds == 2){
            return new int[]{-1,1,0,0};
        }
        if (kinds == 3){
            return new int[]{-1,-1,1,1};
        }
        throw new IllegalArgumentException();
    }
    private int[] getBombSizeX(int kinds){
        if (kinds == 1){
            return new int[]{0,0,0,0};
        }
        if (kinds == 2){
            return new int[]{0,0,-1,1};
        }
        if (kinds == 3){
            return new int[]{-1,1,-1,1};
        }
        throw new IllegalArgumentException();
    }
    private void getBomb(Pos pos, int kinds){
        arr[pos.y][pos.x] = 1;
        int[] dy = getBombSizeY(kinds);
        int[] dx = getBombSizeX(kinds);
        for (int i = 0; i < 4; i++){
            int y = pos.y + dy[i];
            int x = pos.x + dx[i];
            if (inRange(y,x)){
                arr[y][x] = 1;
            }
        }
    }

    private int getBoom(){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private int getTotalBomb(){
        init();
        for (int i = 0; i < list.size(); i++){
            getBomb(list.get(i), bombNum[i]);
        }
        return getBoom();
    }
    private void f(int l){
        if (l == list.size()){
            ans = Math.max(ans, getTotalBomb());
            return;
        }
        for (int i = 1; i <= 3; i++){
            bombNum[l] = i;
            f(l+1);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
                if (now == 1){
                    list.add(new Pos(i,j));
                }
            }
        }
        bombNum = new int[list.size()];
        f(0);
        System.out.println(ans);
    }
}
