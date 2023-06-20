package baekjoon;

import java.io.*;

public class BOJ2003 {
    int n, m;
    int[] arr;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int idx = i;
            int sum = 0;
            while (idx < n && sum < m)
                sum += arr[idx++];
            if (sum == m)
                cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
