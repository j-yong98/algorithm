package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2891 {
    int n, s, r;
    boolean[] arr;

    /**
     * 카약과 강풍
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            arr[idx] = true;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            if (arr[idx])
                arr[idx] = false;
            else if (idx > 0 && arr[idx - 1])
                arr[idx - 1] = false;
            else if (idx < n - 1 && arr[idx + 1])
                arr[idx + 1] = false;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i])
                cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
