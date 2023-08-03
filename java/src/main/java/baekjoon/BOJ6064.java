package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    /**
     * 카잉 달려
     * i, j를 직접 증가시키며 구함 --> 시간 초과
     * 최소 공배수를 구하고 x의 배수로 접근 한다면 x의 배수이기 때문에 나머지는 항상 0이고 해당 수가 N으로 나누었을 때 나머지가 y이면 조건 만족
     * 참고 - 중국인의 나머지 정리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lcm = M * N;
            lcm /= gcd(M, N);
            int res = -1;
            for (int i = x; i <= lcm; i += M) {
                int tmp = i % N;
                if (tmp == 0)
                    tmp = N;
                if (tmp != y) continue;
                res = i;
                break;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
