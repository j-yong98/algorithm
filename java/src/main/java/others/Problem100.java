package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem100 {
    int n, k;
    Map<Integer, Integer> map = new HashMap<>();
    List<int[]> list = new ArrayList<>();

    /**
     * 자주 등장하는 숫자 K개
     * 숫자 N개가 주어지는데 이 숫자가 등장하는 순서대로 K개 출력하라, 단 등장하는 횟수가 같은 경우 더 큰 숫자를 먼저 출력한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        for (Integer integer : map.keySet()) {
            list.add(new int[]{integer, map.get(integer)});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i)[0] + " ");
        }
    }
}
