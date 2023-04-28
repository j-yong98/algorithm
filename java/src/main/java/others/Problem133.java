package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem133 {
    int T;

    /**
     * 오목 판정
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean flag = false;
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++)
                arr[i] = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'o') {
                        if (check(arr, i, j, n)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag)
                    break ;
            }
            if (flag)
                bw.write("#" + t + " YES\n");
            else
                bw.write("#" + t + " NO\n");
        }
        bw.flush();
        bw.close();
    }

    private boolean inRange(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private boolean check(char[][] arr, int y, int x, int n) {
        int cnt = 0;
        for (int j = x; j < x + 5; j++) {
            if (inRange(y, j, n) && arr[y][j] == 'o') {
                cnt++;
                continue;
            }
            break;
        }
        if (cnt >= 5)
            return true;
        cnt = 0;
        for (int i = y; i < y + 5; i++) {
            if (inRange(i, x, n) && arr[i][x] == 'o') {
                cnt++;
                continue;
            }
            break;
        }
        if (cnt >= 5)
            return true;
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (inRange(y + i, x + i, n) && arr[y + i][x + i] == 'o') {
                cnt++;
                continue;
            }
            break;
        }
        if (cnt >= 5)
            return true;
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (inRange(y + i, x - i, n) && arr[y + i][x - i] == 'o') {
                cnt++;
                continue;
            }
            break;
        }
        if (cnt >= 5)
            return true;
        return false;
    }
}
