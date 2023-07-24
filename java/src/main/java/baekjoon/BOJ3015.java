package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3015 {
    int n;

    /**
     * 오아시스 재결합
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Num> s = new Stack<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            Num last = new Num(num, 1);
            while (!s.isEmpty() && s.peek().num <= num) {
                Num top = s.pop();
                ans += top.cnt;
                if (top.num == num)
                    last.cnt += top.cnt;
            }
            if (!s.isEmpty()) ans++;
            s.push(last);
        }
        System.out.println(ans);
    }
    class Num{
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
