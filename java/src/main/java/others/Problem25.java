package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25 {
    private final char START = '1';
    private final char WALL = '#';
    int n;
    int r,c;
    char[][] arr;
    int cnt;
    int dir;
    int[] dy = {0,-1,0,1};
    int[] dx = {1,0,-1,0};

    private void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == r && j == c && arr[i][j] != START){
                    arr[i][j] = '2';
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private boolean isWall(int y, int x){
        if (!inRange(y,x)) return false;
        return arr[y][x] == WALL;
    }

    private boolean move(){
        int cy = r + dy[dir];
        int cx = c + dx[dir];
        while (!hasRight() || isWall(cy,cx)){
            dir = (dir + 1) % 4;
            r = cy;
            c = cx;
        }
        if (!inRange(cy,cx)) return true;
        r = cy;
        c = cx;
        return false;
    }

    private boolean hasRight(){
        int y = r + dy[(dir-1 + 8) % 4];
        int x = c + dx[(dir-1 + 8) % 4];
        return inRange(y,x) && arr[y][x] == WALL;
    }

    private boolean isStart(int y, int x){
        if (arr[y][x] == START) return true;
        return false;
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private boolean simulate(){
        while (true){
            cnt++;
            if (cnt!= 1 && isStart(r,c)) return false;
            if (move()) break;
            print();
        }
        return true;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new char[n][n];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        arr[r][c] = START;
        cnt = 0;
        dir = 0;
        if (!simulate()) System.out.println(-1);
        else System.out.println(cnt);
    }
}
