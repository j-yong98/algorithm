package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem113 {
    int T;
    /**
     * 알파벳 공부
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] arr = br.readLine().toCharArray();
            int cnt = 0;
            char now = 'a';
            for (int i = 0; i < arr.length; i++) {
                if (now != arr[i])
                    break ;
                cnt++;
                now++;
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
