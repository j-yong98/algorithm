package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {
    int N;
    /**
     * 좋은 단어
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < str.length; j++) {
                if (s.isEmpty()) {
                    s.push(str[j]);
                } else {
                    if (s.peek() == str[j])
                        s.pop();
                    else
                        s.push(str[j]);
                }
            }
            if (s.isEmpty())
                ans += 1;
        }
        System.out.println(ans);
        br.close();
    }
}
