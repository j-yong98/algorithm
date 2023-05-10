package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21611 {
    int n, m;
    int[][] arr;
    int ans = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            blizard(d, s);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    private void blizard(int d, int s) {
        int[] tmp = explode(d, s);
        bomb(tmp);
        changeGroup(tmp);
    }

    private int[] explode(int d, int s) {
        Deque<int[]> q = new ArrayDeque<>();
        int[] dy = {0, -1, 1, 0, 0};
        int[] dx = {0, 0, 0, -1, 1};
        int y = n / 2;
        int x = n / 2;
        for (int i = 0; i < s; i++) {
            int yy = y + dy[d];
            int xx = x + dx[d];
            arr[yy][xx] = 0;
            y = yy;
            x = xx;
        }
        arrToQueue(arr, q);
        int[] tmp = new int[n * n];
        int idx = 0;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[2] == 0) continue;
            tmp[idx++] = pos[2];
        }
        return tmp;
    }

    private void arrToQueue(int[][] arr, Deque<int[]> q) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {-1, 0, 1, 0};
        int dir = 0;
        q.clear();
        int y = n / 2;
        int x = n / 2;
        int cnt = 1;
        while (!(y == 0 && x == 0)) {
            for (int i = 0; i < cnt; i++) {
                int yy = y + dy[dir];
                int xx = x + dx[dir];
                q.add(new int[] {yy, xx, arr[yy][xx]});
                y = yy;
                x = xx;
                if (y == 0 && x == 0)
                    break ;
            }
            if (dir % 2 == 1)
                cnt++;
            dir = (dir + 1) % 4;
        }
    }

    private void bomb(int[] tmp) {
        boolean flag = false;
        for (int i = 0; i < n * n; i++) {
            if (tmp[i] == 0) continue;
            int cnt = 1;
            for (int j = i + 1; j < n * n; j++) {
                if (tmp[i] != tmp[j]) break ;
                cnt++;
            }
            if (cnt >= 4) {
                flag = true;
                ans += tmp[i] * cnt;
                for (int j = 0; j < cnt; j++)
                    tmp[i + j] = 0;
            }
        }
        if (flag) {
            int[] tmp2 = new int[n * n];
            int idx = 0;
            for (int i = 0; i < n * n; i++) {
                if (tmp[i] == 0) continue;
                tmp2[idx++] = tmp[i];
            }
            for (int i = 0; i < n * n; i++)
                tmp[i] = tmp2[i];
            bomb(tmp);
        }
    }

    private void changeGroup(int[] tmp) {
        Queue<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n * n;) {
            if (tmp[i] == 0) break;
            int cnt = 1;
            for (int j = i + 1; j < n * n; j++) {
                if (tmp[i] == tmp[j]) cnt++;
                else break ;
            }
            dq.add(cnt);
            dq.add(tmp[i]);
            i += cnt;
        }
        int[] dy = {0, 1, 0, -1};
        int[] dx = {-1, 0, 1, 0};
        int dir = 0;
        int y = n / 2;
        int x = n / 2;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = 0;
        }
        while (!(y == 0 && x == 0) && !dq.isEmpty()) {
            for (int i = 0; i < cnt; i++) {
                int yy = y + dy[dir];
                int xx = x + dx[dir];
                arr[yy][xx] = dq.poll();
                y = yy;
                x = xx;
                if (y == 0 && x == 0 || dq.isEmpty())
                    break ;
            }
            if (dir % 2 == 1)
                cnt++;
            dir = (dir + 1) % 4;
        }
    }
}
