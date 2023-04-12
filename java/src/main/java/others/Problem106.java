package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem106 {
    int T;
    /**
     * 홀수만 더하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 1)
                    sum += num;
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
