package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem29 {
    int n, k, u, d;
    int[][] arr;
    int[][] visited;
    int[][] used;
    int[] dy = {0,1,0,-1};
    int[] dx = {-1,0,1,0};
    Stack<int[]> choose = new Stack<>();
    Queue<int[]> q = new LinkedList<>();

    int ans;

    private void print(){
        for (int[] ints : visited) {
            for (int anInt : ints) {
                System.out.print(anInt +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void initVisited(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visited[i][j] = 0;
            }
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && visited[y][x] == 0;
    }
    private boolean canGo(int y, int x, int yy, int xx){
        int abs = Math.abs(arr[y][x] - arr[yy][xx]);
        return abs >= u && abs <= d;
    }
    private int bfs(){
        initVisited();
        int cnt = 0;
        for (int i = 0; i < choose.size(); i++){
            int[] pos = choose.get(i);
            q.add(pos);
            visited[pos[0]][pos[1]] = 1;
            cnt++;
        }
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x) && canGo(pos[0],pos[1],y,x)){
                    q.add(new int[]{y,x});
                    visited[y][x] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void f(int l,int sum){
        if (l == k) {
            print();
            ans = Math.max(ans,bfs());
            return;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i*n + j < sum) continue;
                if (used[i][j] == 0){
                    used[i][j] = 1;
                    choose.add(new int[]{i,j});
                    f(l+1,i*n+j);
                    choose.pop();
                    used[i][j] = 0;
                }
            }
        }
    }

    /**
     * 도시 n, 서로다른 k개의 도시 선택, 높이 차이가 u이상 d 이하 이동 가능 최대 도시 방문 수
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[n][n];
        used = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0,0);
        System.out.println(ans);
        return ans;
    }
}
