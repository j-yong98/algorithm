package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2885 {
    int k;
    /**
     * 초콜릿 식사
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int size = 1;
        while (size < k) {
            size = size << 1;
        }
        int s = size;
        int cnt = 0;
        while (k > 0) {
            if (k >= size)
                k -= size;
            else {
                size /= 2;
                cnt++;
            }
        }
        bw.write(s + " " + cnt + "\n");
        bw.flush();
        bw.close();
    }
}
