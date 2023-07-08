package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BOJ17298 {
    int n;
    Stack<int[]> s = new Stack<>();
    int[] ans;
    /**
     * 오큰수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        Arrays.fill(ans, -1);
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(line[i]);
            while (!s.isEmpty()) {
                int[] peek = s.peek();
                if (peek[0] < num) {
                    ans[peek[1]] = num;
                    s.pop();
                }
                else
                    break;
            }
            s.push(new int[]{num, i});
        }
        for (int i = 0; i < n; i++)
            bw.write(ans[i] + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
