package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14891 {
    final int TOP = 0;
    final int RIGHT = 2;
    final int LEFT = 6;
    final int N = 4;
    final int M = 8;
    int k;
    int[] check = new int[N];
    int[] visited = new int[N];
    List<int[]> gears = new ArrayList<>();
    private void init() {
        for (int i = 0; i < N; i++)
            check[i] = 0;
        for (int i = 0; i < N; i++)
            visited[i] = 0;
    }
    private void check_dir(int num) {
        if (num != N - 1 && visited[num + 1] == 0 && (gears.get(num)[RIGHT] ^ gears.get(num + 1)[LEFT]) == 1) {
            check[num + 1] = -check[num];
            visited[num + 1] = 1;
            check_dir(num + 1);
        }
        if (num != 0 && visited[num - 1] == 0 && (gears.get(num)[LEFT] ^ gears.get(num - 1)[RIGHT]) == 1) {
            check[num - 1] = -check[num];
            visited[num - 1] = 1;
            check_dir(num - 1);
        }
    }
    private void r_rotate(int num) {
        int[] now = gears.get(num);
        int[] tmp = new int[M];
        //7->6, 6->5, 5->4 ... 0->7
        for (int i = M - 1; i >= 0; i--)
            tmp[(i - 1 + (M * 2)) % M] = now[i];
        for (int i = 0; i < M; i++)
            now[i] = tmp[i];
    }
    private void rotate(int num) {
        int[] now = gears.get(num);
        int[] tmp = new int[M];
        for (int i = 0; i < M; i++)
            tmp[(i + 1) % M] = now[i];
        for (int i = 0; i < M; i++)
            now[i] = tmp[i];
    }
    private int getScore() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (gears.get(i)[TOP] == 1)
            sum += Math.pow(2, i);
        }
        return sum;
    }
    private void simulate(int num, int dir) {
        init();
        check[num] = dir;
        visited[num] = 1;
        check_dir(num);
        for (int i = 0; i < N; i++) {
            if (check[i] == 1)
                rotate(i);
            else if (check[i] == -1)
                r_rotate(i);
        }
    }
    void printGears() {
        for (int i : check)
            System.out.print(i + " ");
        System.out.println();
        for (int[] gear : gears) {
            for (int i : gear) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * 톱니바퀴
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            gears.add(new int[M]);
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++)
                gears.get(i)[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
        }
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            simulate(num, dir);
//            printGears();
        }
        System.out.println(getScore());
    }
}
