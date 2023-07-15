package baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ4889 {
    /**
     * 안정적인 문자열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; ; t++) {
            String line = br.readLine();
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            if (line.contains("-"))
                break;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '{')
                    stack.add('{');
                else { // line.charAt(i) == '}'
                    if (stack.isEmpty()) {
                        cnt++;
                        stack.add('{');
                    }
                    else stack.pop();
                }
            }
            cnt += stack.size() / 2;
            bw.write(t + ". " + cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
