package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ9375 {
    Map<String, Integer> map = new HashMap<>();
    int N;
    int ans;

    /**
     * 패션왕 신해빈
     * 같은 부위의 옷은 입지 못하기 때문에 옷의 종류마다 카운트를 해서 * + 1로 정의 마지막에 옷을 다 벗은 상태를 빼줌
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map.clear();
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                if (!map.containsKey(line[1]))
                    map.put(line[1], 0);
                map.put(line[1], map.get(line[1]) + 1);
            }

            ans = 1;
            for (Integer value : map.values())
                ans *= (value + 1);
            sb.append(ans - 1).append("\n");
        }
        System.out.print(sb);
    }
}
