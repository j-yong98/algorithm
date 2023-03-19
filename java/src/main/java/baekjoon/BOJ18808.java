package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18808 {
    int n, m, k;
    int[][] notebook;
    int[][] cp;
    List<int[][]> stickers = new ArrayList<>();
    List<int[]> s_size = new ArrayList<>();
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
    private void noteToCp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cp[i][j] = notebook[i][j];
            }
        }
    }
    private void cpToNote() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                notebook[i][j] = cp[i][j];
            }
        }
    }
    private boolean display(int y, int x, int seq) {
        int[][] sticker = stickers.get(seq);
        int[] size = s_size.get(seq);
        noteToCp();
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                if (!inRange(y + i, x + j) || (notebook[y + i][x + j] == 1 && sticker[i][j] == 1))
                    return false;
                if (cp[y + i][x + j] == 0)
                    cp[y + i][x + j] = sticker[i][j];
            }
        }
        return true;
    }
    private void rotate(int seq) {
        int[] pos = s_size.get(seq);
        int[][] sticker = stickers.get(seq);
        int[][] tmp = new int[pos[1]][pos[0]];
        for (int i = 0; i < pos[0]; i++) {
            for (int j = 0; j < pos[1]; j++) {
                tmp[j][pos[0] - 1 - i] = sticker[i][j];
            }
        }
        stickers.set(seq, tmp);
        s_size.set(seq, new int[]{pos[1], pos[0]});
    }
    private void attach(int seq, int tries) {
        if (tries == 4)
            return ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (display(i, j, seq)) {
                    cpToNote();
                    return ;
                }
            }
        }
        rotate(seq);
        attach(seq, tries + 1);
    }
    private void simulate(int seq) {
        if (seq == k)
            return ;
        attach(seq, 0);
        simulate(seq + 1);
    }
    private int countSticker() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (notebook[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
    /**
     * 스티커 붙이기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        notebook = new int[n][m];
        cp = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            s_size.add(new int[]{r, c});
            for (int y = 0; y < r; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < c; x++) {
                    sticker[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }
        simulate(0);
        System.out.println(countSticker());
    }
}
