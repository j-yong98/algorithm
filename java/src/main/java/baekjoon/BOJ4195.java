package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4195 {
    int T;
    int F;
    Map<String, Integer> map;
    List<Integer> count;
    List<List<Integer>> parent;

    /**
     * 친구 네트워크
     * union-find문제 + 카운팅 배열 생성 후 연결 관계 수 표시
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());
            int idx = 0;
            map = new HashMap<>();
            parent = new ArrayList<>();
            count = new ArrayList<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    parent.add(new ArrayList<>());
                    parent.get(idx).add(idx);
                    map.put(a, idx++);
                    count.add(1);
                }
                if (!map.containsKey(b)) {
                    parent.add(new ArrayList<>());
                    parent.get(idx).add(idx);
                    map.put(b, idx++);
                    count.add(1);
                }
                int p1 = findParent(map.get(a));
                int p2 = findParent(map.get(b));

                if (p1 != p2)
                    union(map.get(a), map.get(b));
                sb.append(Math.max(count.get(p1), count.get(p2))).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 < p2) {
            parent.get(p2).set(0, p1);
            count.set(p1, count.get(p1) + count.get(p2));
            count.set(p2, 0);
        }
        else {
            parent.get(p1).set(0, p2);
            count.set(p2, count.get(p1) + count.get(p2));
            count.set(p1, 0);
        }
    }

    private int findParent(int a) {
        if (a == parent.get(a).get(0)) return a;
        int p = findParent(parent.get(a).get(0));
        parent.get(a).set(0, p);
        return p;
    }
}
