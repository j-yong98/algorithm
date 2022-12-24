package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem28 {
    int[] dy = {0,1,0,-1};
    int[] dx = {-1,0,1,0};
    Queue<int[]> q = new LinkedList<>();
    int n,m;
    int[][] arr;
    int[][] visited;

    private void initVisited(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                visited[i][j] = 0;
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    private void bfs(int r, int c){
        initVisited();
        q.add(new int[]{r,c});
        visited[r][c] = 1;
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x) && arr[y][x] == 0 && visited[y][x] == 0){
                    visited[y][x] = 1;
                    q.add(new int[]{y,x});
                }
            }
        }
    }

    private int melt(){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int k = 0; k < 4; k++){
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (inRange(y,x) && arr[i][j] == 1 && visited[y][x] == 1){
                        arr[i][j] = 0;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean check(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 1) return false;
            }
        }
        return true;
    }

    private void print(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        int cnt = 0;
        while (true){
            if (check()) break;
            bfs(0,0);
            ans++;
            cnt = melt();
        }
        System.out.println(ans + " "+cnt);
        return new int[]{ans,cnt};
    }
}
