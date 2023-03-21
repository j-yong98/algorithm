package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    class Dice {
        int top;
        int bottom;
        int front;
        int back;
        int right;
        int left;

        public Dice() {
            top = 0;
            bottom = 0;
            front = 0;
            back = 0;
            right = 0;
            left = 0;
        }
        public void east() {
            int tmp = bottom;
            bottom = right;
            right = top;
            top = left;
            left = tmp;
        }
        public void west() {
            int tmp = bottom;
            bottom = left;
            left = top;
            top = right;
            right = tmp;
        }
        public void north() {
            int tmp = bottom;
            bottom = back;
            back = top;
            top = front;
            front = tmp;
        }
        public void south() {
            int tmp = bottom;
            bottom = front;
            front = top;
            top = back;
            back = tmp;
        }
    }
    int n, m;
    int y, x;
    int k;
    int[][] arr;
    int[] dy = {0, 0, -1, 1};
    int[] dx = {1, -1, 0, 0};
    Dice dice = new Dice();
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
    private void move(int dir) {
        if (dir == 0)
            dice.east();
        else if (dir == 1)
            dice.west();
        else if (dir == 2)
            dice.north();
        else if (dir == 3)
            dice.south();
    }
    private void set_map_dice() {
        if (arr[y][x] == 0)
            arr[y][x] = dice.bottom;
        else {
            dice.bottom = arr[y][x];
            arr[y][x] = 0;
        }
    }
    /**
     * 주사위 굴리기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            if (!inRange(y + dy[dir], x + dx[dir]))
                continue ;
            y += dy[dir];
            x += dx[dir];
            move(dir);
            System.out.println(dice.top);
            set_map_dice();
        }
    }
}
