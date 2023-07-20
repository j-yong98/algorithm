package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {
    final int MAX = 1_000_000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        int[] tmp = new int[n];
        int[] cnt = new int[MAX + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp[i] = Integer.parseInt(st.nextToken());
            cnt[tmp[i]]++;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!s.isEmpty()) {
                if (cnt[tmp[i]] < cnt[s.peek()]) {
                    arr[i] = s.peek();
                    break;
                } else {
                    s.pop();
                }
            }
            s.add(tmp[i]);
        }

        for (int i = 0; i < n; i++)
            sb.append(arr[i]).append(" ");
        System.out.print(sb);
    }
}
