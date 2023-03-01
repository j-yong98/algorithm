package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem102 {
    int n;
    Map<Integer, Integer> map = new HashMap<>();
    long ans;

    /**
     * x, y가 주어지는데 x값 마다 제일 작은 y값 하나만을 가질 수 있는데 최종적으로 남은 y값들의 합을 구하는 문제
     * 1 <= n <= 100,000
     * -10^9 <= x,y <= 10^9
     * 이기 때문에 x가 서로 다르고 y값이 10억일 경우를 고려해 답을 담는 변수는 long이 되어야 한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                if (map.get(key) > value)
                    map.put(key, value);
            }
            else map.put(key, value);
        }
        for (Integer value : map.values()) {
            ans += value;
        }
        System.out.println(ans);
    }
}
