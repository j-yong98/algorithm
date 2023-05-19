package others;

import java.io.*;

public class Problem154 {
    int T;
    int k;
    int ans;

    /**
     * 최대 상금
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            String[] line = br.readLine().split(" ");
            String num = line[0];
            k = Integer.parseInt(line[1]);
            getMaxNum(0, 0, num);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void getMaxNum(int l, int s, String num) {
        if (l == k || l == num.length()) {
            ans = Math.max(ans, Integer.valueOf(num));
            return;
        }
        int len = num.length();
        for (int i = s; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                String tmp = swap(num, i, j);
                getMaxNum(l + 1, i + 1, tmp);
            }
        }
    }

    private String swap(String num, int a, int b) {
        int len = num.length();
        char[] tmp = new char[len];

        for (int i = 0; i < len; i++)
            tmp[i] = num.charAt(i);

        char ch = tmp[a];
        tmp[a] = tmp[b];
        tmp[b] = ch;
        return String.valueOf(tmp);
    }
}
