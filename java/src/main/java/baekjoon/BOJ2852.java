package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2852 {
    final int MAX_MIN = 48;
    int N;
    int[][] score = new int[3][MAX_MIN * 60];
    int[] ans = new int[3];
    /**
     * NBA 농구
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            int time = StringToInt(st.nextToken());
            for (int j = time; j < MAX_MIN * 60; j++)
                score[teamNum][j] += 1;
        }
        for (int i = 0; i < MAX_MIN * 60; i++) {
            int s1 = score[1][i];
            int s2 = score[2][i];
            if (s1 == s2) continue;
            else if (s1 > s2) ans[1]++;
            else ans[2]++;
        }
        System.out.println(intToString(ans[1]) + "\n" + intToString(ans[2]));
        br.close();
    }

    private String intToString(int time) {
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d:%02d", min, sec);
    }

    private int StringToInt(String time) {
        String[] minSec = time.split(":");
        int min = Integer.parseInt(minSec[0]);
        int sec = Integer.parseInt(minSec[1]);
        return (min * 60) + sec;
    }
}
