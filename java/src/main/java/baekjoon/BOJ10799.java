package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    int ans;
    Stack<Character> s = new Stack<>();
    /**
     * 쇠막대기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') s.push(c);
            else {
                s.pop();
                if (line.charAt(i - 1) == '(')
                    ans += s.size();
                else
                    ans +=1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
