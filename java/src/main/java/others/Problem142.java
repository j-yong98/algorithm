package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem142 {
    int n;
    int[] b;
    boolean[] checked;
    int cnt = 0;
    /**
     * 문제이름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = new int[n];
        checked = new boolean[2 * n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            b[i] = num;
            checked[num] = true;
        }
        for (int i = 0; i < n; i++) {
            int num = b[i];
            int tmp = 0;
            for (int j = 1; j < num; j++) {
                if (!checked[j]) {
                    tmp = j;
                    break ;
                }
            }
            for (int j = num + 1; j <= 2 * n; j++) {
                if (!checked[j]) {
                    tmp = j;
                    break ;
                }
            }
            checked[tmp] = true;
            if (tmp > num)
                cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
