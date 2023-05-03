package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem144 {
    int T;
    /**
     * 외로운 문자
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] str = br.readLine().toCharArray();
            int[] arr = new int[26];
            boolean flag = true;
            String ans = "";
            for (int i = 0; i < str.length; i++) {
                int idx = str[i] - 'a';
                arr[idx] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (arr[i] % 2 != 0) {
                    flag = false;
                    ans += (char) (i + 'a');
                }
            }
            if (flag) ans = "Good";
            ans += "\n";
            bw.write("#" + t + " " + ans);
        }
        bw.flush();
        bw.close();
    }
}
