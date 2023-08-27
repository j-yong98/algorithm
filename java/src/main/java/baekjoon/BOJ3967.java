package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ3967 {
    static final int[][] LINE1 = {{0, 4}, {1, 3}, {2, 2}, {3, 1}};
    static final int[][] LINE2 = {{0, 4}, {1, 5}, {2, 6}, {3, 7}};
    static final int[][] LINE3 = {{1, 1}, {1, 3}, {1, 5}, {1, 7}};
    static final int[][] LINE4 = {{3, 1}, {3, 3}, {3, 5}, {3, 7}};
    static final int[][] LINE5 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
    static final int[][] LINE6 = {{1, 7}, {2, 6}, {3, 5}, {4, 4}};
    static final int[][][] LINES = {LINE1, LINE2, LINE3, LINE4, LINE5, LINE6};
    static final int N = 5;
    static final int M = 9;
    static final char BLANK = 'x';
    static char[][] arr = new char[N][M];
    static List<int[]> pos = new ArrayList<>();
    String pickAns = "";
    String ans = null;

    /**
     * 매직 스타
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int visited = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == BLANK)
                    pos.add(new int[]{i, j});
                else {
                    if (Character.isAlphabetic(arr[i][j])) {
                        visited |= 1 << (arr[i][j] - 'A');
                    }
                }
            }
        }
        backTracking(0, visited, "");
        System.out.println(ans);
        br.close();
    }

    private void backTracking(int n, int visited, String pick) {
        if (!lineCheck()) return;
        if (n == pos.size()) {
            makeAns(pick);
            return;
        }
        int[] p = pos.get(n);
        for (int i = 0; i < 12; i++) {
            if ((visited & (1 << i)) != 0) continue;
            if (!compare(pickAns, pick + ((char) (i + 'A')))) continue;
            arr[p[0]][p[1]] = (char) (i + 'A');
            backTracking(n + 1, visited | (1 << i), pick + ((char) (i + 'A')));
            arr[p[0]][p[1]] = BLANK;
        }
    }

    private boolean lineCheck() {
        for (int i = 0; i < LINES.length; i++) {
            int sum = 0;
            for (int j = 0; j < LINES[i].length; j++) {
                if (arr[LINES[i][j][0]][LINES[i][j][1]] == BLANK) continue;
                sum += arr[LINES[i][j][0]][LINES[i][j][1]] - 'A' + 1;
                if (sum > 26) return false;
            }
        }
        return true;
    }

    private boolean compare(String a, String b) {
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++)
            if (a.charAt(i) < b.charAt(i)) return false;
        return true;
    }

    private void makeAns(String pick) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        if (ans == null) {
            ans = sb.toString();
            pickAns = pick;
        }
        else {
            if (ans.compareTo(sb.toString()) > 0) {
                ans = sb.toString();
                pickAns = pick;
            }
        }
    }
}
