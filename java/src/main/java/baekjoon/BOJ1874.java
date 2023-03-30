package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1874 {
    int n;
    Stack<Integer> s = new Stack<>();
    int[] ans;
    StringBuilder sb = new StringBuilder();
    /**
     * 스택 수열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ans[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            s.push(i); sb.append("+\n");
            while (!s.isEmpty() && ans[idx] == s.peek()) {
                s.pop(); sb.append("-\n");
                idx++;
            }
        }
        if (!s.isEmpty())
            System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
