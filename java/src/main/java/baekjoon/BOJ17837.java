package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17837 {
    static class Piece {
        int num;
        int r;
        int c;
        int d;
        boolean turn;
        public Piece(int num, int r, int c, int d) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.d = d;
            this.turn = false;
        }
    }
    final int WHITE = 0;
    final int RED = 1;
    final int BLUE = 2;
    int n, k;
    int[][] arr;
    int[] dy = {0, 0, 0, -1, 1};
    int[] dx = {0, 1, -1, 0, 0};
    List<Piece> pieces = new ArrayList<>();
    Deque<Piece>[][] q;
    int ans = 0;
    private void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                q[i][j] = new ArrayDeque<>();
        }
        for (int i = 0; i < k; i++) {
            Piece p = pieces.get(i);
            q[p.r][p.c].add(p);
        }
    }

    /**
     *  새로운 게임 2
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        q = new ArrayDeque[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pieces.add(new Piece(i, r, c, d));
        }
        init();
        while (ans <= 1000) {
            ans++;
            if (!move())
                break ;
        }
        System.out.println(ans == 1001 ? -1 : ans);
        return ans == 1001 ? -1 : ans;
    }
    private boolean inRange(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
    }
    private int changeDir(int d) {
        if (d == 1)
            return 2;
        if (d == 2)
            return 1;
        if (d == 3)
            return 4;
        if (d == 4)
            return 3;
        throw new IllegalArgumentException();
    }
    private boolean move() {
        for (int i = 0; i < k; i++) {
            Piece p = pieces.get(i);
            int y = p.r + dy[p.d];
            int x = p.c + dx[p.d];
            if (!inRange(y, x) || arr[y][x] == BLUE) {
                p.d = changeDir(p.d);
                y = p.r + dy[p.d];
                x = p.c + dx[p.d];
            }
            if (inRange(y, x) && arr[y][x] == RED) {
                while (!q[p.r][p.c].isEmpty()) {
                    Piece piece = q[p.r][p.c].pollLast();
                    piece.r = y;
                    piece.c = x;
                    q[y][x].addLast(piece);
                    if (piece.num == p.num) break ;
                }
            }
            else if (inRange(y, x) && arr[y][x] == WHITE) {
                Deque<Piece> tmp = new ArrayDeque<>();
                while(!q[p.r][p.c].isEmpty()) {
                    Piece piece= q[p.r][p.c].pollLast();
                    piece.r = y;
                    piece.c = x;
                    tmp.addLast(piece);
                    if (piece.num == p.num) break ;
                }
                while (!tmp.isEmpty())
                    q[y][x].add(tmp.pollLast());
            }
            if (q[p.r][p.c].size() >= 4)
                return false;
        }
        return true;
    }
    private void printMap() {
        System.out.println("=====================================================================");
        for (int i = 1; i <= n ;i++) {
            for (int j = 1; j <= n; j++) {
                String str = "";
                if (q[i][j].isEmpty())
                    str = "e";
                for (Piece num : q[i][j]) {
                    str += num.num + ",";
                }
                System.out.printf("%7s", str);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("=====================================================================");
    }
}
