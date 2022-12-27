package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem42 {
    int n, k;
    int[][] arr;
    int[][] dist;

    Queue<int[]> q = new LinkedList<>();
    private void init(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
    }
    private void findValidateTangerine(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 2){
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && arr[y][x] == 1 && dist[y][x] == -1;
    }
    private void bfs(){
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        findValidateTangerine();
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    q.add(new int[]{y,x});
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                }
            }
        }
    }
    private void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 0){
                    System.out.print(-1 +" ");
                }
                else if (arr[i][j] == 1 && dist[i][j] == -1){
                    System.out.print(-2 +" ");
                }
                else{
                    System.out.print(dist[i][j]+" ");
                }
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
        arr = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        bfs();
        print();
    }
}
