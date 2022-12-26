package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem36 {
    int n;
    int r1, c1, r2, c2;

    int[][] dist;

    int[] dy = {-2, -2, -1, -1,  1, 1,  2, 2};
    int[] dx = {-1,  1, -2,  2, -2, 2, -1, 1};

    Queue<int[]> q = new LinkedList<>();

    private void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y > 0 && y <= n && x > 0 && x <= n && dist[y][x] == -1;
    }

    private void print(){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.printf("%d  ",dist[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dist = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        q.add(new int[]{r1, c1});
        init();
        dist[r1][c1] = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            if (pos[0] == r2 && pos[1] == c2) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    q.add(new int[]{y,x});
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                }
            }
        }
        System.out.println(dist[r2][c2]);
        return dist[r2][c2];
    }
}
