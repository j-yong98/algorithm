package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1305 {
    String str;
    int L;
    int[] arr;
    /**
     * 광고
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        arr = new int[L];
        str = br.readLine();
        int j = 0;
        for (int i = 1; i < L; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = arr[j - 1];
            if (str.charAt(i) == str.charAt(j))
                arr[i] = ++j;
        }
        System.out.println(L - arr[L - 1]);
        br.close();
    }
}
