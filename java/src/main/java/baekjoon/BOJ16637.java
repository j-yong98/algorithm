package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16637 {
    final char ADD = '+';
    final char SUB = '-';
    final char MUL = '*';
    int n;
    char[] exp;
    boolean[] checked;
    int ans = Integer.MIN_VALUE;
    /**
     * 괄호 추가하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        exp = br.readLine().toCharArray();
        getMaxValue(2, exp[0] - 48);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
    private void getMaxValue(int numIdx, int sum) {
        if (numIdx >= n) {
            ans = Math.max(ans, sum);
            return;
        }
        getMaxValue(numIdx + 2, calc(sum, exp[numIdx] - 48, exp[numIdx - 1]));
        if (numIdx + 2 < n) {
            int right = calc(exp[numIdx] - 48, exp[numIdx + 2] - 48, exp[numIdx + 1]);
            getMaxValue(numIdx + 4, calc(sum, right, exp[numIdx - 1]));
        }
    }
    private int calc(int a, int b, char op) {
        if (op == ADD)
            return a + b;
        if (op == SUB)
            return a - b;
        if (op == MUL)
            return a * b;
        throw new IllegalArgumentException();
    }
}
