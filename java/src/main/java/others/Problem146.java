package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem146 {
    int T;
    /**
     * 순열 1
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            String ans = "Yes";
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (arr[num] > 0)
                    ans = "No";
                arr[num]++;
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
