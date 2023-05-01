package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ19236 {
    final int BLANK = 0;
    final int SIZE = 4;
    List<int[]> fishes = new ArrayList<>();
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    int ans = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                fishes.add(new int[]{i, j, s, d});
            }
        }
        int[] info = fishes.get(0);
        fishes.remove(info);
        simulate(0, 0, info[2], info[3], fishes);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
    private void simulate(int r, int c, int sum, int dir, List<int[]> alive) {
        for (int k = 1; k <= SIZE * SIZE; k++) {
            for (int i = 0; i < alive.size(); i++) {
                if (alive.get(i)[2] == k)
                    move(r, c, alive.get(i), alive);
            }
        }
        if (!canGo(r, c, dir, alive)) {
            ans = Math.max(ans, sum);
            return ;
        }
        for (int i = 1; ; i++) {
            int y = r + (dy[dir] * i);
            int x = c + (dx[dir] * i);
            if (!inRange(y, x))
                break ;
            int[] fish = findFish(y, x, alive);
            if (fish == null)
                continue;
            List<int[]> tmp = eatFish(fish, alive);
            simulate(fish[0], fish[1], sum + fish[2], fish[3], tmp);
        }
    }
    private boolean canGo(int r, int c, int d, List<int[]> alive) {
        for (int i = 1; ;i++) {
            int y = r + (dy[d] * i);
            int x = c + (dx[d] * i);
            if (!inRange(y, x))
                break ;
            for (int j = 0; j < alive.size(); j++) {
                int[] fish = alive.get(j);
                if (y == fish[0] && x == fish[1])
                    return true;
            }
        }
        return false;
    }
    private List<int[]> eatFish(int[] target, List<int[]> alive) {
        List<int[]> ret = new ArrayList();
        for (int i = 0; i < alive.size(); i++) {
            int[] fish = alive.get(i);
            if (fish[2] == target[2]) continue;
            ret.add(new int[]{fish[0], fish[1], fish[2], fish[3]});
        }
        return ret;
    }
    private int[] findFish(int y, int x, List<int[]> alive) {
        for (int i = 0; i < alive.size(); i++) {
            int[] fish = alive.get(i);
            if (fish[0] == y && fish[1] == x)
                return fish;
        }
        return null;
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < SIZE && x >= 0 && x < SIZE;
    }
    private void move(int r, int c, int[] fish, List<int[]> alive) {
        int y = fish[0] + dy[fish[3]];
        int x = fish[1] + dx[fish[3]];
        while (!inRange(y, x) || (y == r && x == c)) {
            fish[3] = (fish[3] + 1) % 8;
            y = fish[0] + dy[fish[3]];
            x = fish[1] + dx[fish[3]];
        }
        boolean isSame = false;
        for (int i = 0; i < alive.size(); i++) {
            int[] f = alive.get(i);
            if (f[2] == fish[2]) continue;
            if (f[0] == y && f[1] == x) {
                isSame = true;
                int tmp1 = fish[0];
                int tmp2 = fish[1];
                fish[0] = y;
                fish[1] = x;
                f[0] = tmp1;
                f[1] = tmp2;
                break;
            }
        }
        if (!isSame) {
            fish[0] = y;
            fish[1] = x;
        }
    }
}
