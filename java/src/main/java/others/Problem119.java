package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem119 {
    int T;
    int n;
    char[][] arr;
    /**
     * 문제이름
     */
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] line = br.readLine().toCharArray();
                arr[i] = line;
            }
            if (search())
                bw.write("#" + t + " " + "yes\n");
            else
                bw.write("#" + t + " " + "no\n");
        }
        bw.flush();
        bw.close();
    }
    private boolean search() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '#') {
                    if (i < minY)
                        minY = i;
                    if (i > maxY)
                        maxY = i;
                    if (j > maxX)
                        maxX = j;
                    if (j < minX)
                        minX = j;
                }
            }
        }
        int width = maxX - minX;
        int height = maxY - minY;
        if (width != height)
            return false;
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                if (arr[i][j] != '#')
                    return false;
            }
        }
        return true;
    }
}
