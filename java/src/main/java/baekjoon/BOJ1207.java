package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1207 {
    final int SIZE = 5;
    int N;
    List<int[]>[] papers;
    List<int[]> papersSize = new ArrayList<>();
    int cnt;
    int[] orders = new int[SIZE];
    String ans = null;

    /**
     * 종이 자르기
     * 붙이면서 재귀를 돌면 모든 위치를 다 파악하기 때문에 최악의 경우 10x10의 경우를 재귀로 다 돌아 시간초과
     * 따라서 종이의 순서를 구해 놓고 해당 순서에 따라 연속적으로 붙여본다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        papers = new List[SIZE];
        for (int i = 0; i < SIZE; i++)
            orders[i] = i;
        for (int d = 0; d < 5; d++) {
            papers[d] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            papersSize.add(new int[]{r, c});
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    char val = line.charAt(j);
                    if (val == '#')
                        papers[d].add(new int[]{i, j});
                }
            }
        }
        do {
            makePaper();
        } while (np());
        if (ans == null)
            System.out.println("gg");
        else {
            System.out.println(ans);
        }
        br.close();
    }

    private boolean np() {
        int i = SIZE - 1;
        while (i > 0 && orders[i - 1] >= orders[i]) i--;

        if (i == 0) return false;

        int j = SIZE - 1;
        while (orders[i - 1] >= orders[j]) j--;
        swap(i - 1, j);

        int k = SIZE - 1;
        while (i < k) swap(i++, k--);
        return true;
    }

    private void swap(int a, int b) {
        orders[a] ^= orders[b];
        orders[b] ^= orders[a];
        orders[a] ^= orders[b];
    }

    private void makePaper() {
        int[][] arr = new int[N][N];
        cnt = N * N;

        int c = 0;
        for (int d = 0; d < SIZE; d++) {
            int num = orders[d];
            boolean can = false;
            for (int i = 0; i < N - papersSize.get(num)[0] + 1; i++) {
                for (int j = 0; j < N - papersSize.get(num)[1] + 1; j++) {
                    if (!canAttack(num, arr, i, j)) continue;
                    can = true;
                    attach(num, arr, i, j);
                    c++;
                    break;
                }
                if (can) break;
            }
        }

        if (cnt == 0 && c == SIZE) {
            String tmp = makeString(arr);
            if (ans == null)
                ans = tmp;
            else {
                if (ans.compareTo(tmp) > 0)
                    ans = tmp;
            }
        }
    }

    private String makeString(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean canAttack(int num, int[][] arr, int y, int x) {
        List<int[]> pos = papers[num];
        for (int[] p : pos)
            if (arr[y + p[0]][x + p[1]] != 0) return false;
        return true;
    }

    private void attach(int num, int[][] arr, int y, int x) {
        List<int[]> pos = papers[num];
        for (int[] p : pos) {
            cnt--;
            arr[y + p[0]][x + p[1]] = num + 1;
        }
    }
}
