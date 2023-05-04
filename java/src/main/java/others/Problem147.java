package others;

import java.io.*;
import java.util.*;

public class Problem147 {
    int n;
    List<int[]> list = new ArrayList<>();
    /**
     * 자연수 m/2개의 쌍
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{y, x});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int[] l = list.get(left);
            int[] r = list.get(right);
            ans = Math.max(ans, l[0] + r[0]);
            if (l[1] == r[1]) {
                left++;
                right--;
            }
            else if (l[1] > r[1]) {
                l[1] -= r[1];
                right--;
                list.set(left, l);
            }
            else {
                r[1] -= l[1];
                left++;
                list.set(right, r);
            }
        }
        bw.write(ans  + "\n");
        bw.flush();
        bw.close();
    }
}
