package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20044 {
    int n;
    int[] arr;
    /**
     * Project Teams
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int end = 2 * n - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ability = arr[i] + arr[end - i];
            if (ability < min)
                min = ability;
        }
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
