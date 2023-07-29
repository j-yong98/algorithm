package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20114 {
    int n, h, w;
    char[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new char[n];
        Arrays.fill(arr, '?');
        for (int i = 0; i < h; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == '?') continue;
                arr[j / w] = word.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i]);
        System.out.println(sb);
    }
}
