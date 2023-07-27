package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1107 {
    final int SIZE = 10;
    int n, m;

    int min;
    boolean[] digits = new boolean[SIZE];

    /**
     * 리모컨
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        if (m != 0) {
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(line[i]);
                digits[num] = true;
            }
        }

        min = Math.abs(100 - n);

        moveChannel("");
        System.out.println(min);
        br.close();
    }

    private void moveChannel(String tmp) {
        StringBuilder sb = new StringBuilder();
        sb.append(tmp);
        for (int i = 0; i < SIZE; i++) {
            if (digits[i]) continue;
            sb.append(i);
            min = Math.min(min, Math.abs(n - Integer.parseInt(sb.toString())) + sb.length());
            if (sb.length() < 6)
                moveChannel(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
