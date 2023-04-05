package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {
    int n, l;
    int[][] arr;
    int ans = 0;
    private boolean crossBridge(int[] bridge) {
        boolean[] checked = new boolean[n];
        int height = bridge[0];
        for (int i = 1; i < n;) {
            if (height == bridge[i]) {
                i++;
                continue;
            }
            if (Math.abs(bridge[i] - height) > 1)
                return false;
            //오른쪽이 더 큰 경우(오르막)
            if (bridge[i] > height) {
                if (i - l < 0)
                    return false;
                for (int j = 1; j <= l; j++) {
                    if (checked[i - j] || height != bridge[i - j])
                        return false;
                    checked[i - j] = true;
                }
                height = bridge[i++];
            }
            //오른쪽이 작은 경우(내리막)
            else {
                if (i + l - 1 >= n)
                    return false;
                for (int j = 0; j < l; j++) {
                    if (checked[i + j] || bridge[i] != bridge[i + j])
                        return false;
                    checked[i + j] = true;
                }
                i += l - 1;
                if (i < n)
                    height = bridge[i];
            }
        }
        return true;
    }
    private int canGo(int y, int x) {
        int cnt = 0;
        int[] tmp = new int[n];
        if (y == 0) {
            for (int i = 0; i < n; i++)
                tmp[i] = arr[i][x];
            if (crossBridge(tmp))
                cnt++;
        }
        if (x == 0) {
            for (int j = 0; j < n; j++)
                tmp[j] = arr[y][j];
            if (crossBridge(tmp))
                cnt++;
        }
        return cnt;
    }
    /**
     * 경사로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        ans += canGo(0, 0);
        for (int i = 1; i < n; i++) {
            ans += canGo(i, 0);
        }
        for (int j = 1; j < n; j++) {
            ans += canGo(0, j);
        }
        System.out.println(ans);
    }
}
