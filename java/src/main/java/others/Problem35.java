package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem35 {
    int n,m;
    int[][] arr;
    int[][] dist;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    Queue<int[]> q = new LinkedList<>();

    private void initDist(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dist[i][j] = -1;
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < m && arr[y][x] == 1 && dist[y][x] == -1;
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initDist();
        dist[0][0] = 0;
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                    q.add(new int[]{y,x});
                }
            }
        }

        System.out.println(dist[n-1][m-1]);
        return dist[n-1][m-1];
    }
}
