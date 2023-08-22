package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4396 {
    final int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int N;
    char[][] arr;
    char[][] click;

    /**
     * 지뢰 찾기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        click = new char[N][N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++)
            click[i] = br.readLine().toCharArray();
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (click[i][j] == 'x') {
                    if (arr[i][j] == '*')
                        flag = true;
                    else
                        click[i][j] = (char) (count(i, j) + '0');
                }
            }
        }
        if (flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == '*')
                        click[i][j] = '*';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(click[i][j]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private int count(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx)) continue;
            if (arr[yy][xx] == '*') cnt++;
        }
        return cnt;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
