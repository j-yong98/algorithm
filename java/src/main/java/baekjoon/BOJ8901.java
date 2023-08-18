package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ8901 {
    int N = 3;
    int T;

    /**
     * 화학 제품
     * a의 개수를 정하면 ab의 개수를 정할 수 있고
     * 이후 b의 개수가 정해지고 bc의 개수가 정해지기 떄문에 ac의 개수도 알 수 있게 된다.
     * 하지만 ab ac bc를 만드는 경우도 생각해 둘 중 더 최댓값을 취한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ab = Integer.parseInt(st.nextToken());
            int bc = Integer.parseInt(st.nextToken());
            int ca = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= Math.min(a, b); i++) {
                int bcTmp = Math.min(b - i, c);
                int caTmp = Math.min(c - bcTmp, a - i);

                ans = Math.max(ans, ab * i + bc * bcTmp + ca * caTmp);

                caTmp = Math.min(c, a - i);
                bcTmp = Math.min(c - caTmp, b - i);

                ans = Math.max(ans, ab * i + bc * bcTmp + ca * caTmp);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
