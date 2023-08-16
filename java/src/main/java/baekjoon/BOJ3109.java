package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
    final int[] DY = {-1, 0, 1};
    final int[] DX = {1, 1, 1};
    int R, C;
    char[][] arr;
    int ans = 0;

    /**
     * 빵집
     * 그리디 + 백트래킹
     * 파이프를 좌상단으로 몰면 아래 위치들의 파이프 공간이 확보 되기 때문에 좌상단으로 몰아 개수를 센다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < R; i++)
            backTracking(i, 0, i);
        System.out.println(ans);
    }

    private boolean backTracking(int y, int x, int num) {
        if (x == C - 1) {
            ans++;
            return true;
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            int yy = y + DY[i];
            int xx = x + DX[i];
            if (!inRange(yy, xx) || arr[yy][xx] != '.') continue;
            arr[yy][xx] = (char) ((num + 1) + '0');
            flag = backTracking(yy, xx, num);
            if (flag) return flag;
        }

        return flag;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
