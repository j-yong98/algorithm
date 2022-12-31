package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem54 {
    private final int MAX = 6;
    int[] arr = new int[MAX];
    int ans = 0;
    String exp;

    private int calc() {
        int res;
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '-' || ch == '*' || ch == '+') {
                op = ch;
            } else {
                stack.push(arr[(int) ch - 'a']);
                if (stack.size() == 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    if (op == '+') {
                        stack.push(num2 + num1);
                    } else if (op == '-') {
                        stack.push(num2 - num1);
                    } else {
                        stack.push(num1 * num2);
                    }
                }
            }
        }
        res = stack.pop();
        return res;
    }

    private void f(int l) {
        if (l == MAX) {
            int res = calc();
            if (res > ans){
                ans = res;
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            arr[l] = i;
            f(l + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
        f(0);
        System.out.println(ans);
    }
}
