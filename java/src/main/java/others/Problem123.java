package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem123 {
    int T;
    /**
     * 교환 학생
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 7; i++) {
                if (arr[i] == 1) {
                    int s = i;
                    int day = 0;
                    int cnt = 0;
                    while (n > cnt) {
                        if (arr[s] == 1)
                            cnt++;
                        s = (s + 1) % 7;
                        day++;
                    }
                    ans = Math.min(ans, day);
                }
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}

