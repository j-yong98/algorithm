package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 {
    final int TEAM_SIZE = 6;
    final int SIZE = 3;
    int[][] arr = new int[TEAM_SIZE][SIZE];
    int[][] orders = new int[TEAM_SIZE * SIZE - SIZE][2];
    int[][] tmp = new int[TEAM_SIZE][SIZE];
    boolean flag = false;
    StringBuilder sb = new StringBuilder();


    /**
     * 월드컵
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        for (int i = 0; i < TEAM_SIZE; i++) {
            for (int j = i + 1; j < TEAM_SIZE; j++) {
                orders[idx][0] = i;
                orders[idx][1] = j;
                idx++;
            }
        }
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            flag = false;
            recursion(0);
            if (!flag)
                sb.append(0).append(" ");
            else
                sb.append(1).append(" ");
        }
        System.out.println(sb);
    }

    private void recursion(int n) {
        if (flag)
            return;
        if (n == (TEAM_SIZE * SIZE - SIZE)) {
            if (check())
                flag = true;
            return;
        }
        int a = orders[n][0];
        int b = orders[n][1];
        for (int i = 0; i < 3; i++) {
            tmp[a][i] += 1;
            tmp[b][SIZE - i - 1] += 1;
            recursion(n + 1);
            tmp[a][i] -= 1;
            tmp[b][SIZE - i - 1] -= 1;
        }
    }

    private void printMap() {
        for (int i = 0; i < TEAM_SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(tmp[i][j] + " ");
            System.out.println();
        }
        System.out.println("=========================================");
    }

    private boolean check() {
        for (int i = 0; i < TEAM_SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tmp[i][j] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
