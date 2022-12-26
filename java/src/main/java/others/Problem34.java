package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem34 {
    int n,m,k;
    int[][] arr;
    int time;
    List<int[]> snake;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};

    private void print(){
        for (int i = 0; i < snake.size(); i++){
            arr[snake.get(i)[0]][snake.get(i)[1]] = 2;
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private int getDir(String dir){
        if (dir.equals("U")) return 0;
        if (dir.equals("D")) return 1;
        if (dir.equals("L")) return 2;
        if (dir.equals("R")) return 3;
        throw new IllegalArgumentException();
    }
    private boolean isCollide(int y, int x){
        for (int i = 0; i < snake.size();i++){
            int[] body = snake.get(i);
            if (y == body[0] && x == body[1]){
                return true;
            }
        }
        return false;
    }
    private boolean move(int y, int x){
        if (arr[y][x] == 1){
            arr[y][x] = 0;
            if (isCollide(y,x)) return false;
            snake.add(0,new int[]{y,x});
        }
        else{
            snake.remove(snake.size()-1);
            if (isCollide(y,x)) return false;
            snake.add(0,new int[]{y,x});
        }
        return true;
    }
    private boolean simulate(int dir, int dist){
        for (int i = 0; i < dist; i++) {
            int y = snake.get(0)[0] + dy[dir];
            int x = snake.get(0)[1] + dx[dir];
            time++;
            if (!inRange(y, x)) return false;
            if (!move(y,x)) return false;
            print();
        }
        return true;
    }

    /**
     * 뱀의 이동 - NxN 크기의 격자 안에서 뱀이 움직일 때 꼬이거나 범위를 벗어나면 종료, 1은 사과 먹으면 몸의 길이가 1증가, 이동은 U,D,L,R과 이동 거리가 주어진다.
     * 게임이 종료 될 때 까지 몇 초가 걸리는가?
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        snake = new ArrayList<>();
        snake.add(new int[]{0,0});

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }
        time = 0;
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int dir = getDir(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(!simulate(dir, dist)) break;
        }
        System.out.println(time);
        return time;
    }
}
