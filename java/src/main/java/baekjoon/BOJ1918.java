package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    String exp;
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.add(c);
            }
            else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
                    sb.append(stack.pop());
                stack.add(c);
            }
            else if (c == '(')
                stack.add(c);
            else if (c == ')') {
                while (!stack.isEmpty() && (stack.peek() != '(')) {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else
                sb.append(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
