package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20056 {
    class Fireball {
        int r, c;
        int mass;
        int dir;
        int speed;

        public Fireball(int r, int c, int mass, int dir, int speed) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.dir = dir;
            this.speed = speed;
        }
    }

    int n, m, k;
    List<Fireball> fireballs = new ArrayList<>();
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    private void merge() {
        List<Fireball>[][] map = new List[n][n];
        List<Fireball> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                map[i][j] = new ArrayList<>();
        }
        for (int i = 0; i < fireballs.size(); i++) {
            Fireball fb = fireballs.get(i);
            map[fb.r][fb.c].add(fb);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() == 1) {
                    tmp.add(map[i][j].get(0));
                } else if (map[i][j].size() >= 2) {
                    int mass = 0;
                    int speed = 0;
                    int dir = 0;
                    for (int c = 0; c < map[i][j].size(); c++) {
                        Fireball fb = map[i][j].get(c);
                        mass += fb.mass;
                        speed += fb.speed;
                        dir += fb.dir % 2;
                    }
                    mass /= 5;
                    if (mass == 0)
                        continue;
                    speed /= map[i][j].size();
                    int c = (dir == 0 || dir == map[i][j].size()) ? 0 : 1;
                    for (; c < 8; c += 2) {
                        tmp.add(new Fireball(i, j, mass, c, speed));
                    }
                }
            }
        }
        fireballs = tmp;
    }

    /**
     * 마법사 상어와 파이어볼
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, d, s));
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < fireballs.size(); j++) {
                Fireball fb = fireballs.get(j);
                for (int c = 0; c < fb.speed; c++) {
                    fb.r = (fb.r + dy[fb.dir] + n) % n;
                    fb.c = (fb.c + dx[fb.dir] + n) % n;
                }
            }
            merge();
        }
        int sum = 0;
        for (int i = 0; i < fireballs.size(); i++) {
            sum += fireballs.get(i).mass;
        }
        System.out.println(sum);
    }
}
