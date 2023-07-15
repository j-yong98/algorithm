package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2174 {
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, -1, 0, 1};
    int a, b;
    int n, m;
    int[][][] arr;
    boolean flag;

    /**
     * 로봇 시뮬레이션
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[b + 1][a + 1][2];
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = b - Integer.parseInt(st.nextToken()) + 1;
            int d = getDir(st.nextToken().charAt(0));
            arr[y][x][0] = i;
            arr[y][x][1] = d;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            flag = simulate(num, cmd, repeat);
            if (!flag) break;
        }
        if (flag)
            System.out.print("OK");
        br.close();
    }

    private int[] findRobot(int num) {
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= a; j++) {
                if (arr[i][j][0] == num)
                    return new int[]{i, j, arr[i][j][1]};
            }
        }
        return new int[]{-1, -1, -1};
    }

    private boolean simulate(int num, char cmd, int repeat) {
        int[] robot = findRobot(num);
        if (cmd == 'F') {
            arr[robot[0]][robot[1]][0] = 0;
            arr[robot[0]][robot[1]][1] = 0;
            for (int i = 0; i < repeat; i++) {
                int y = robot[0] + dy[robot[2]];
                int x = robot[1] + dx[robot[2]];
                if (!inRange(y, x)) {
                    System.out.println("Robot " + (num) + " crashes into the wall");
                    return false;
                }
                if (arr[y][x][0] != 0) {
                    System.out.println("Robot " + (num) + " crashes into robot " + arr[y][x][0]);
                    return false;
                }
                robot[0] = y;
                robot[1] = x;
            }
        } else if (cmd == 'L') {
            for (int i = 0; i < repeat; i++)
                robot[2] = (robot[2] + 1) % 4;
        }
        else {
            for (int i = 0; i < repeat; i++)
                robot[2] = (robot[2] + 4 - 1) % 4;
        }
        arr[robot[0]][robot[1]][0] = num;
        arr[robot[0]][robot[1]][1] = robot[2];
        return true;
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= b && x >= 1 && x <= a;
    }

    private int getDir(char dir) {
        if (dir == 'N')
            return 0;
        if (dir == 'W')
            return 1;
        if (dir == 'S')
            return 2;
        if (dir == 'E')
            return 3;
        return -1;
    }
}
