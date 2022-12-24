package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem27 {
    private final int MAX = 999999;
    int n,m,k;
    int[][] arr;
    int[][][] visited;
    boolean isRemove;
    int r, c;

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void initVisited(){
        isRemove = false;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[k][i][j] = MAX;
                }
            }
        }
    }
    private void bfs(){
        int[] dy = {0,1,0,-1};
        int[] dx = {-1,0,1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,m});
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    if (arr[y][x] == 0 && visited[0][y][x] == MAX){
                        visited[0][y][x] = visited[1][pos[0]][pos[1]] + 1;
                        visited[1][y][x] = visited[1][pos[0]][pos[1]] + 1;
                        q.add(new int[]{y,x,pos[2]});
                    }
                    else if (arr[y][x] == 1 && pos[2] > 0 && visited[1][y][x] == MAX){
                        visited[1][y][x] = visited[1][pos[0]][pos[1]] + 1;
                        q.add(new int[]{y,x,pos[2] - 1});
                        isRemove = true;
                    }
                }
            }
        }
    }
    private int findMax(){
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[0][i][j] != MAX) ans++;
            }
        }
        return isRemove ? ans + m : ans;
    }
    void print(){
        for (int[][] ints : visited) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.print(i == MAX ? -1+" " : i + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[2][n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            initVisited();
            visited[0][r][c] = 0;
            visited[1][r][c] = 0;
            bfs();
            print();
            ans = Math.max(ans,findMax());
        }
        System.out.println(ans);
    }
}
