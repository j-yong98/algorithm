package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem115 {
    int T;
    /**
     * 공과 잡초
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] str = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0; i < str.length - 1; i++) {
                if (str[i] == '(') {
                    if (str[i + 1] == ')' || str[i + 1] == '|')
                        cnt++;
                }
                else if (str[i] == '|') {
                    if (str[i + 1] == ')')
                        cnt++;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
