package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem160 {
    int T;
    int n;
    int[] company = new int[2];
    int[] home = new int[2];
    int[][] arr;
    int[] selected;
    int ans;
    /**
     * 최적 경로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            selected = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++)
                company[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 2; i++)
                home[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            ans = Integer.MAX_VALUE;
            getMinDist(0, 0, home, 0);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void getMinDist(int l, int visited, int[] now, int dist) {
        if (l == n) {
            ans = Math.min(ans, dist + getDist(now, company));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0)
                continue;
            selected[l] = i;
            getMinDist(l + 1, visited | (1 << i), new int[]{arr[i][0],arr[i][1]}, dist + getDist(now, arr[i]));
        }
    }

    private int getDist(int[] now, int[] dest) {
        return Math.abs(now[0] - dest[0]) + Math.abs(now[1] - dest[1]);
    }
}
