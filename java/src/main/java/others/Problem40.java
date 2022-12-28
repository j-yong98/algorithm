package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem40 {
    int n, k;
    int r1,c1,r2,c2;
    int[][] arr;
    int[][][] dist;

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        q.add(new int[]{r1,c1,k});
        dist[0][r1][c1] = 0;
        dist[1][r1][c1] = 0;
        while (!q.isEmpty()){
            int[] pos = q.poll();
            if (pos[0] == r2 && pos[1] == c2){
                break;
            }
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    if (arr[y][x] == 0 && dist[0][y][x] == -1){
                        dist[0][y][x] = dist[0][pos[0]][pos[1]] + 1;
                        dist[1][y][x] = dist[1][pos[0]][pos[1]] + 1;
                        q.add(new int[]{y,x,pos[2]});
                    }
                    else if(arr[y][x] == 1 && pos[2] > 0 && dist[1][y][x] == -1){
                        dist[1][y][x] = dist[1][pos[0]][pos[1]] + 1;
                        q.add(new int[]{y,x,pos[2]-1});
                    }
                }
            }
        }
    }
    private void print(){
        for (int k = 0; k < 2; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(dist[k][i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dist = new int[2][n][n];
        for (int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    dist[i][j][k] = -1;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;
        bfs();
        System.out.println(Math.max(dist[0][r2][c2],dist[1][r2][c2]));
        return Math.max(dist[0][r2][c2],dist[1][r2][c2]);
    }
}
