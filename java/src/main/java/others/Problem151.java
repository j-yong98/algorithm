package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem151 {
    int T;
    /**
     * 진용이네 주차타워
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] space = new int[n + 1];
            int[] fee = new int[n + 1];
            for (int i = 1; i <= n; i++)
                fee[i] = Integer.parseInt(br.readLine());
            int[] weight = new int[m + 1];
            for (int i = 1; i <= m; i++)
                weight[i] = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 1; i <= 2 * m; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num > 0) {
                    int min = 0;
                    for (int j = 1; j <= n; j++) {
                        if (space[j] == 0) {
                            min = j;
                            break ;
                        }
                    }
                    if (min == 0)
                        q.add(num);
                    else
                        space[min] = num;
                }
                else {
                    num *= -1;
                    for (int j = 1; j <= n; j++) {
                        if (space[j] == num) {
                            ans += fee[j] * weight[num];
                            space[j] = 0;
                            break ;
                        }
                    }
                    if (!q.isEmpty()) {
                        int tmp = q.pollFirst();
                        for (int j = 1; j <= n; j++) {
                            if (space[j] == 0)
                                space[j] = tmp;
                        }
                    }
                }
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
