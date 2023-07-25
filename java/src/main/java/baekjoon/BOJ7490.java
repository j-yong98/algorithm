package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7490 {
    final char[] EXP = {'+', '-', ' '};
    int T;
    int n;
    char[] selected;
    int[] number;
    List<String> ans;

    /**
     * 0으로 만들기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            selected = new char[n - 1];
            number = new int[n];
            ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
                number[i] = i + 1;
            comb(0);
            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.size(); i++)
                sb.append(ans.get(i));
            System.out.print(sb);
            System.out.println();
        }
    }

    private void comb(int l) {
        if (l == n - 1) {
            if (getSum() == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n - 1; i++) {
                    sb.append(i + 1);
                    sb.append(selected[i]);
                }
                sb.append(n).append("\n");
                ans.add(sb.toString());
            }
            return ;
        }
        for (int i = 0; i < 3; i++) {
            selected[l] = EXP[i];
            comb(l + 1);
        }
    }

    private int getSum() {
        Deque<Integer> s = new ArrayDeque<>();
        s.add(1);
        for (int i = 0; i < n - 1; i++) {
            if (selected[i] != ' ')
                s.addLast(i + 2);
            else {
                s.addLast(trans(s.pollLast(), i + 2));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (selected[i] == ' ') continue;
            int a = s.pollFirst();
            int b = s.pollFirst();
            s.addFirst(calc(selected[i], a, b));
        }
        return s.pollFirst();
    }

    private int calc(char exp, int a, int b) {
        if (exp == '+')
            return a + b;
        return a - b;
    }

    private int trans(int a, int b) {
        return a * 10 + b;
    }
}
