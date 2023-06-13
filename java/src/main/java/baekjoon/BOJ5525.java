package baekjoon;

import java.io.*;

public class BOJ5525 {
    int n, m;
    char[] arr;

    int ans = 0;

    /**
     * IOIOI
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        for (int i = 0; i < m; i++) {
            if (arr[i] == 'O')
                continue;
            int cnt = 0;
            while (i < m - 2 && arr[i + 1] == 'O' && arr[i + 2] == 'I') {
                cnt++;
                if (cnt == n) {
                    ans++;
                    cnt--;
                }
                i += 2;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
