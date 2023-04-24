package others;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem124 {
    int T;
    /**
     * 두 전구
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int max = Arrays.stream(arr).max().getAsInt();
            int cnt = 0;
            for (int i = 0; i <= max; i++) {
                if (i >= arr[0] && i < arr[1] && i >= arr[2] && i < arr[3])
                    cnt++;
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
