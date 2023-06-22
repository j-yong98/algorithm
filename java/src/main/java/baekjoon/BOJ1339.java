package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1339 {
    int n;
    String[] arr;
    List<Character> list = new ArrayList<>();
    Set<Character> set = new HashSet<>();
    int[] alpha = new int[26];
    long ans = 0;
    /**
     * 단어 수학
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                if (set.contains(str.charAt(j)))
                    continue;
                set.add(str.charAt(j));
                list.add(str.charAt(j));
            }
        }
        dfs(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int l, int visited) {
        if (l == set.size()) {
            ans = Math.max(ans, getSum());
           return ;
        }
        for (int i = 0; i < 10; i++) {
            if ((visited & (1 << i)) != 0)
                continue;
            alpha[list.get(l) - 65] = i;
            dfs(l + 1, visited | (1 << i));
        }
    }

    private long getSum() {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += parse(arr[i]);
        }
        return res;
    }

    private long parse(String str) {
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = (res * 10) + alpha[str.charAt(i) - 65];
        }
        return res;
    }
}
