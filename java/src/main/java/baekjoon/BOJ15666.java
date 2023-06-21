package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ15666 {
    int n, m;
    int[] arr;
    HashSet<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

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
        Arrays.sort(arr);
        comb(0, 0, "");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void comb(int l, int s, String selected) {
        if (l == m) {
            if (set.contains(selected))
                return;
            set.add(selected);
            sb.append(selected).append("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            comb(l + 1, i, selected + arr[i] + " ");
        }
    }
}