package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2529 {
    int N;
    char[] arr;
    int[] num;
    List<String> ans = new ArrayList<>();
    /**
     * 부등호
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[N];
        for (int i = 0; i < N; i++)
            arr[i] = st.nextToken().charAt(0);
        num = new int[N + 1];
        for (int i = 9; i >= 0; i--) {
            num[0] = i;
            backTracking(1, 1 << i);
        }
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1) + "\n" + ans.get(0));
        br.close();
    }

    private void backTracking(int idx, int visited) {
        if (idx == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= N; i++)
                sb.append(num[i]);
            ans.add(sb.toString());
            return;
        }
        char sign = arr[idx - 1];
        int num1 = num[idx - 1];
        if (sign == '>') {
            for (int i = num1 - 1; i >= 0; i--) {
                if ((visited & (1 << i)) != 0) continue;
                num[idx] = i;
                backTracking(idx + 1, visited | (1 << i));
            }
        } else {
            for (int i = num1 + 1; i <= 9; i++) {
                if ((visited & (1 << i)) != 0) continue;
                num[idx] = i;
                backTracking(idx + 1, visited | (1 << i));
            }
        }
    }
}
