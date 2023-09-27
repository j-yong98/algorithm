package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1213 {
    int N;
    String str;
    int[] cnt = new int[26];
    char[] arr;
    StringBuilder sb = new StringBuilder();

    /**
     * 팰린드롬 만들기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++)
            cnt[str.charAt(i) - 'A']++;
        if (str.length() % 2 == 0)
            N = str.length() / 2;
        else
            N = str.length() / 2 + 1;
        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1)
                oddCnt++;
        }
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            boolean flag = false;
            arr = new char[str.length()];
            for (int i = 0; i < 26; i++) {
                if (cnt[i] % 2 == 1) {
                    arr[str.length() / 2] = (char) (i + 'A');
                    cnt[i]--;
                    flag = true;
                }
            }
            if (flag)
                dfs(1, 0);
            else
                dfs(0, 0);
        }
        System.out.println(sb);
    }

    private void dfs(int l, int idx) {
        if (sb.length() != 0) return;
        if (l == N) {
            for (int i = 0; i < str.length(); i++)
                sb.append(arr[i]);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            arr[idx] = (char) (i + 'A');
            arr[str.length() - idx - 1] = (char) (i + 'A');
            cnt[i] -= 2;
            dfs(l + 1, idx + 1);
            cnt[i] += 2;
        }
    }
}
