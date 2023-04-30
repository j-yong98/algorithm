package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem140 {
    int n;
    int ans = -1;
    /**
     * 수 채우기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if (n % 5 == 0)
            ans = n / 5;
        else {
            int cnt = 1;
            while (true) {
                int tmp = n - (cnt * 5);
                if (tmp < 0)
                    break ;
                if (tmp % 2 == 0)
                    ans = cnt + (tmp / 2);
                cnt++;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
