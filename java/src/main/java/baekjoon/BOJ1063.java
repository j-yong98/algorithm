package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1063 {
    int[] king;
    int[] dol;
    int N;

    /**
     * 킹
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = getPos(st.nextToken());
        dol = getPos(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int[] delta = getDelta(cmd);
            move(king, delta);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(toAlpha(king[1])).append(king[0]).append("\n");
        sb.append(toAlpha(dol[1])).append(dol[0]).append("\n");
        System.out.print(sb);
    }

    private void move(int[] pos, int[] delta) {
        int y = pos[0] + delta[0];
        int x = pos[1] + delta[1];
        if (!inRange(y, x) || !check(y, x, delta)) return;
        king[0] = y;
        king[1] = x;
    }

    private boolean check(int y, int x, int[] delta) {
        if (y == dol[0] && x == dol[1]) {
            int yy = dol[0] + delta[0];
            int xx = dol[1] + delta[1];
            if (!inRange(yy, xx)) return false;
            dol[0] = yy;
            dol[1] = xx;
        }
        return true;
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= 8 && x >= 1 && x <= 8;
    }

    private int[] getDelta(String cmd) {
        if (cmd.equals("R"))
            return new int[] {0, 1};
        if (cmd.equals("L"))
            return new int[] {0, -1};
        if (cmd.equals("B"))
            return new int[] {-1, 0};
        if (cmd.equals("T"))
            return new int[] {1, 0};
        if (cmd.equals("RT"))
            return new int[] {1, 1};
        if (cmd.equals("LT"))
            return new int[] {1, -1};
        if (cmd.equals("RB"))
            return new int[] {-1, 1};
        if (cmd.equals("LB"))
            return new int[] {-1, -1};
        throw new IllegalArgumentException();
    }

    private char toAlpha(int r) {
        return (char) (r - 1 + 'A');
    }

    private int[] getPos(String str) {
        int[] pos = new int[2];
        pos[1] = convert(str.charAt(0));
        pos[0] = str.charAt(1) - '0';
        return pos;
    }

    private int convert(char c) {
        return c - 'A' + 1;
    }
}
