package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2660 {
    final int MAX = 10_000_000;
    int n;
    boolean[][] arr;
    List<Integer> ans = new ArrayList<>();
    /**
     * 회장 뽑기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];
        while (true) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            if (a == -1 && b == -1) break;
            arr[a][b] = arr[b][a] = true;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int res = getScore(i);
            if (res > min) continue;
            if (res < min) {
                ans.clear();
                min = res;
            }
            ans.add(i);
        }
        bw.write(min + " " + ans.size() + "\n");
        for (Integer num : ans)
            bw.write(num + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int getScore(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] score = new int[n + 1];
        Arrays.fill(score, -1);
        q.add(start);
        score[start] = 0;

        while (!q.isEmpty()) {
            Integer num = q.poll();
            for (int i = 1; i <= n; i++) {
                if (score[i] == -1 && arr[num][i]) {
                    q.add(i);
                    score[i] = score[num] + 1;
                }
            }
        }
        return Arrays.stream(score).max().getAsInt();
    }
}
