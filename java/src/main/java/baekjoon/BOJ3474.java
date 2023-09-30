package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3474 {
    int N;
    /**
     * 교수가 된 현우
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int num = Integer.parseInt(br.readLine());
            int cnt1 = 0;
            long tmp = 2;
            while (tmp <= num) {
                cnt1 += num / tmp;
                tmp *= 2;
            }

            int cnt2 = 0;
            tmp = 5;
            while (tmp <= num) {
                cnt2 += num / tmp;
                tmp *= 5;
            }
            sb.append(Math.min(cnt1, cnt2)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
