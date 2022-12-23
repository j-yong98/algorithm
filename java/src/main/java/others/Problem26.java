package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem26 {
    int n, k;
    int[][] arr;
    int[][] visited;
    Queue<int[]> q = new LinkedList<>();
    int r, c;
    int now;
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && arr[y][x] < now && visited[y][x] == 0;
    }
    private void initVisited(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visited[i][j] = 0;
            }
        }
    }
    private void bfs(){
        initVisited();
        int[] dy = {0,1,0,-1};
        int[] dx = {-1,0,1,0};
        q.add(new int[]{r,c});
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    q.add(new int[]{y,x});
                    visited[y][x] = 1;
                }
            }
        }
    }

    private void findPos(){
        int value = 0;
        int maxY = r;
        int maxX = c;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j] == 0 || i == r && j == c) continue;
                if (arr[i][j] > value){
                    maxY = i;
                    maxX = j;
                    value = arr[i][j];
                }
                else if (arr[i][j] == value){
                    if (maxY > i){
                        maxY = i;
                        maxX = j;
                    }
                    else if (maxY == i && maxX > j){
                        maxX = j;
                    }
                }
            }
        }
        r = maxY;
        c = maxX;
    }

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < k; i++){
            now = arr[r][c];
            bfs();
            findPos();
        }
        System.out.println((r+1)+" "+(c+1));
        return new int[]{r+1,c+1};
    }
}
