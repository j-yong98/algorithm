package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem121 {
    int T;
    /**
     * 숫자 조작
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] line = br.readLine().toCharArray();
            char[] min = new char[line.length];
            char[] max = new char[line.length];
            for (int i = 0; i < line.length; i++) {
                min[i] = line[i];
                max[i] = line[i];
            }
            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    if (i == 0 && line[j] == '0')
                        continue;
                    swap(line, i, j);
                    if (cmp(min, line) > 0) {
                        for (int idx = 0; idx < line.length; idx++)
                            min[idx] = line[idx];
                    }
                    if (cmp(max, line) < 0) {
                        for (int idx = 0; idx < line.length; idx++)
                            max[idx] = line[idx];
                    }
                    swap(line, j, i);
                }
            }
            bw.write("#" + t + " " + String.valueOf(min) + " " + String.valueOf(max) + "\n");
        }
        bw.flush();
        bw.close();
    }
    private int cmp(char[] a, char[] b) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i])
                return (int)a[i] - (int)b[i];
        }
        return 0;
    }
    private void swap(char[] line, int a, int b) {
        char tmp = line[a];
        line[a] = line[b];
        line[b] = tmp;
    }
}
