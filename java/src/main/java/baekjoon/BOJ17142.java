package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {
    final int VIRUS = 2;
    int n,m;
    int[][] arr;
    int[][] dist;
    List<int[]> virus = new ArrayList<>();
    List<int[]> selectedVirus = new ArrayList<>();
    Queue<int[]> q = new LinkedList<>();
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int ans = Integer.MAX_VALUE;
    private void init(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
        for (int i = 0; i < selectedVirus.size(); i++){
            int[] pos = selectedVirus.get(i);
            q.add(pos);
            dist[pos[0]][pos[1]] = 0;
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && (arr[y][x] == 0 || arr[y][x] == VIRUS) && dist[y][x] == -1;
    }
    private void bfs(){
        init();
        while(!q.isEmpty()){
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
    private int findMin(){
        int value = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 0 && dist[i][j] == -1) return Integer.MAX_VALUE;
                if (arr[i][j] == 0) value = Math.max(value, dist[i][j]);
            }
        }
        return value;
    }
    private void f(int l){
        if (l == virus.size() || selectedVirus.size() == m){
            bfs();
            int min = findMin();
            ans = Math.min(ans,min);
            return;
        }
        selectedVirus.add(virus.get(l));
        f(l+1);
        selectedVirus.remove(virus.get(l));
        f(l+1);
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
                if (now == VIRUS)  virus.add(new int[]{i,j});
            }
        }
        f(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
