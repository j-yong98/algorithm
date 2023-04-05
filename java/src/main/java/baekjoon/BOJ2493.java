package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    class Tower {
        int height;
        int idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
    int n;
    Stack<Tower> stack = new Stack<>();
    /**
     * 탑
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height < val)
                    stack.pop();
                else {
                    System.out.print(stack.peek().idx + " ");
                    break;
                }
            }
            if (stack.isEmpty())
                System.out.print(0 + " ");
            stack.push(new Tower(val, i + 1));
        }
    }
}
