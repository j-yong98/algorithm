package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25 {

    private final char USER = '1';
    private final char WALL = '#';
    private final char VISITED = '2';

    int n;
    int y,x;
    char[][] arr;

    public int[][] rotate(int n, int[][] arr){
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tmp[n-j-1][i] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
        return arr;
    }

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private boolean hasRight(){
        int dy = 0;
        int dx = 1;
        if (inRange(y + dy, x + dx) && arr[y + dy][x + dx] == WALL) return true;
        return false;
    }
    private void foward(){
        arr[y--][x] = VISITED;
        if (inRange(y,x)) {
            arr[y][x] = '1';
        }
    }

    private void findPos(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == USER) {
                    y = i;
                    x = j;
                }
            }
        }
    }
    private void rotate(){
        char[][] tmp = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tmp[n-j-1][i] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
        findPos();
    }
    private boolean canGo(){
        if (inRange(y-1,x) && !isVisited() && arr[y-1][x] != WALL) return true;
        return false;
    }
    private int move(){
        print();
        if(hasRight() && canGo()){
            foward();
            return 1;
        }
        else{
            rotate();
            if (canGo()) {
                foward();
                return 1;
            }
        }
        return 0;
    }
    private void print(){
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private boolean isVisited(){
        if (inRange(y-1,x) && arr[y-1][x] == VISITED) return true;
        return false;
    }
    private int simulate(){
        int cnt = 0;
        while (true){
            if (isVisited()) return -1;
            if (!inRange(y-1,x) && hasRight()){
                cnt++;
                return cnt;
            }
            cnt += move();
        }
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        arr = new char[n][n];

        for (int i = 0; i < n; i++){
            String[] readLine = br.readLine().split("");
            for (int j = 0; j < n; j++){
                arr[i][j] = readLine[j].charAt(0);
            }
        }
        arr[y][x] = USER;
        rotate();
        int ans = simulate();
        System.out.println(ans);
        return ans;
    }
}
