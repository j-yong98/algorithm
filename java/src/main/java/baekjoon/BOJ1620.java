package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    int n, m;
    HashMap<Integer, String> num_poketmon = new HashMap<>();
    HashMap<String, Integer> poketmon_num = new HashMap<>();
    /**
     * 나는야 포켓몬 마스터 이다솜
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String poketmon = st.nextToken();
            num_poketmon.put(i, poketmon);
            poketmon_num.put(poketmon, i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if (poketmon_num.containsKey(q))
                System.out.println(poketmon_num.get(q));
            else System.out.println(num_poketmon.get(Integer.parseInt(q)));
        }
    }
}
