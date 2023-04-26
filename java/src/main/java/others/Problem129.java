package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem129 {
    int n;
    int ans = Integer.MIN_VALUE;
    /**
     * 연속 부분 합의 최댓값 구하기 (그리디)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
