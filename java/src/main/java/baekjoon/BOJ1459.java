package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1459 {
    long x, y, w, s;
    /**
     * 걷기
     */
    public long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        long cost1 = (x + y) * w;
        long cost2;
        if ((x + y) % 2 == 0)
            cost2 = Math.max(x, y) * s;
        else
            cost2 = (Math.max(x, y) - 1) * s + w;
        long cost3 = (Math.min(x, y) * s) + (Math.abs(x - y) * w);
        long ans = Math.min(cost1, Math.min(cost2, cost3));
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        return ans;
    }
}
