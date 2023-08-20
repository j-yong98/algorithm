package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ23291 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int N, K;
    int[][] arr;
    int ans = 0;

    /**
     * 어항 정리
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[N][i] = Integer.parseInt(st.nextToken());
        while (!maxMinDiff()) {
            ans++;
            putFish();

            roll();
            rebalance();
            remakeOneRow();

            fold();
            rebalance();
            remakeOneRow();
        }
        System.out.println(ans);
        br.close();
        return ans;
    }

    private void putFish() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++)
            min = Math.min(min, arr[N][i]);

        for (int i = 1; i <= N; i++)
            if (min == arr[N][i]) arr[N][i]++;
    }

    private void roll() {
        int start, h, w;

        start = h = w = 1;
        for (int idx = 1; ; idx++) {
            if (start - 1 + w + h > N) break;
            for (int i = start; i < start + w; i++) {
                for (int j = N; j > N - h; j--) {
                    int yy = (N - w) + (i - start);
                    int xx = (start + w) + (N - j);
                    arr[yy][xx] = arr[j][i];
                    arr[j][i] = 0;
                }
            }
            start += w;
            if (idx % 2 == 1) h++;
            else w++;
        }
    }

    private void fold() {
        int mid = N / 2;
        for (int i = 1; i <= mid / 2; i++) {
            arr[N][i] ^= arr[N][mid - i + 1];
            arr[N][mid - i + 1] ^= arr[N][i];
            arr[N][i] ^= arr[N][mid - i + 1];
        }
        for (int i = 1; i <= mid; i++) {
            arr[N - 1][mid + i] = arr[N][i];
            arr[N][i] = 0;
        }

        int mid2 = (N - mid) / 2;
        int[][] tmp = new int[2][mid2];
        for (int i = N - 1; i <= N; i++) {
            for (int j = mid + 1; j <= mid + mid2; j++) {
                tmp[i - (N - 1)][j - (mid + 1)] = arr[i][j];
                arr[i][j] = 0;
            }
        }
        tmp = rotate(tmp, 2, mid2);
        tmp = rotate(tmp, mid2, 2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < mid2; j++) {
                arr[(N - 3) + i][N - mid2 + (j + 1)] = tmp[i][j];
            }
        }
    }

    private int[][] rotate(int[][] src, int h, int w) {
        int[][] tmp = new int[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tmp[j][h - i - 1] = src[i][j];
            }
        }
        return tmp;
    }

    private void rebalance() {
        int[][] tmp = new int[N + 1][N + 1];
        copyArr(arr, tmp);
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0) continue;
                q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || arr[yy][xx] == 0) continue;
                int diff = (arr[pos[0]][pos[1]] - arr[yy][xx]) / 5;
                if (diff < 0) continue;
                tmp[pos[0]][pos[1]] -= diff;
                tmp[yy][xx] += diff;
            }
        }

        copyArr(tmp, arr);
    }

    private void copyArr(int[][] src, int[][] dst) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    private void remakeOneRow() {
        int idx = 1;
        int[] tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= 1; j--) {
                if (arr[j][i] == 0) continue;
                tmp[idx++] = arr[j][i];
                arr[j][i] = 0;
            }
        }

        for (int i = 1; i <= N; i++)
            arr[N][i] = tmp[i];
    }

    private boolean maxMinDiff() {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, arr[N][i]);
            max = Math.max(max, arr[N][i]);
        }
        return max - min <= K;
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}
