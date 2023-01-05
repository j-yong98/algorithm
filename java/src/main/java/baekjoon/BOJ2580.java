package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
    final int N = 9;
    final int[][] arr = new int[N][N];
    List<int[]> list = new ArrayList<>();

    boolean isFinish = false;

    private boolean inRange(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < N;
    }
    private boolean canUse(int y, int x, int v){
        for (int i = 1; i < N; i++){
            if (inRange(y,x+i) && v == arr[y][x+i]) return false;
            if (inRange(y,x - i) && v == arr[y][x-i]) return false;
        }
        for (int i = 1; i < N; i++){
            if (inRange(y+i,x) && arr[y+i][x] == v) return false;
            if (inRange(y-i,x) && arr[y-i][x] == v) return false;
        }
        int rangeY = y / 3 * 3;
        int rangeX = x / 3 * 3;
        for (int i = rangeY; i < rangeY + 3; i++){
            for (int j = rangeX; j < rangeX + 3; j++){
                if (y == i && x == j) continue;
                if (arr[i][j] == v) return false;
            }
        }
        return true;
    }
    private boolean isPossible(int y, int x, int v){
        if (!canUse(y,x,v)) return false;
        return true;
    }
    private void print(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
    private void f(int l){
        if (isFinish) return;
        if (l == list.size()){
            print();
            isFinish = true;
            return;
        }
        int[] pos = list.get(l);
        for (int i = 1; i <= 9; i++){
            if (isPossible(pos[0],pos[1],i)) {
                arr[pos[0]][pos[1]] = i;
                f(l + 1);
                arr[pos[0]][pos[1]] = 0;
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (arr[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        f(0);
    }
}
