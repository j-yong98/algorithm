package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198 {
    int n;
    Stack<Integer> s = new Stack<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!s.isEmpty()) {
                if (s.peek() <= h)
                    s.pop();
                else break ;
            }
            s.push(h);
            cnt += s.size() - 1;
        }
        System.out.println(cnt);
    }
}
