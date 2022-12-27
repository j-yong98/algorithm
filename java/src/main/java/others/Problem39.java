package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem39 {

    private final int WALL = 1;
    private final int USER = 2;
    private final int SAFE = 3;
    int n, h, m;
    int[][] arr;
    int[][] dist;
    int[][] ans;

    Queue<int[]> q = new LinkedList<>();
    private void init(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
    }
    private void save(int y, int x){
        ans[y][x] = dist[y][x] == 0 ? -1 : dist[y][x];
    }
    private void print(){
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && arr[y][x] != WALL && dist[y][x] == -1;
    }
    private void bfs(int y, int x){
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        q.add(new int[]{y,x});
        dist[y][x] = 0;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy,xx)){
                    if (arr[yy][xx] == SAFE){
                        dist[y][x] = dist[pos[0]][pos[1]] + 1;
                        while (!q.isEmpty()){
                            q.poll();
                        }
                        return;
                    } else {
                        dist[yy][xx] = dist[pos[0]][pos[1]] + 1;
                        q.add(new int[]{yy,xx});
                    }
                }
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dist = new int[n][n];
        ans = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == USER){
                    init();
                    bfs(i,j);
                    save(i,j);
                }
            }
        }
        print();
    }
}
