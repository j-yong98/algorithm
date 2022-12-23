package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem23 {
    int n;
    Pos pos;
    int[][] arr;

    boolean move;

    class Pos{
        private int y;
        private int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    public void findPos(){
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        for (int i = 0; i < 4; i++){
            int yy = pos.y + dy[i];
            int xx = pos.x + dx[i];
            if (inRange(yy,xx) && arr[yy][xx] > arr[pos.y][pos.x]){
                pos.y = yy;
                pos.x = xx;
                move = true;
                break;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[n][n];
        pos = new Pos(r,c);

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            System.out.print(arr[pos.y][pos.x]+" ");
            move = false;
            findPos();
            if (!move) break;
        }
    }
}
