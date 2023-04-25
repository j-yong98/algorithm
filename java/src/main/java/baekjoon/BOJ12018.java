package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ12018 {
    int n, m;
    int[] list;
    /**
     * Yonsei TOTO
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            list[i] = 1;
            if (p >= l) {
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < p; j++)
                    tmp.add(Integer.valueOf(st.nextToken()));
                Collections.sort(tmp, Collections.reverseOrder());
                list[i] = tmp.get(l - 1);
            }
        }
        Arrays.sort(list);
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list[i];
            if (sum > m)
                break;
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
