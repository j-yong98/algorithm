package others;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem128 {
    int n, k;
    List<Integer> list = new ArrayList<>();
    int ans = 0;
    /**
     * 동전 더하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            ans += k / list.get(i);
            k %= list.get(i);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
