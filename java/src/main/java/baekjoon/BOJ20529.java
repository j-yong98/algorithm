package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20529 {
    int T;
    int N;
    List<String> mbti;
    Map<String, Integer> map;

    /**
     * 가장 가까운 세 사람의 심리적 거리
     * 3명의 사람의 심리적으로 가까운 최소 거리를 구하는 문제이기 때문에 똑같은 MBTI가 3개 이상 나온다면 어차피 0이기 때문에 의미가 없다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            mbti = new ArrayList<>();
            map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String str = st.nextToken();
                if (map.containsKey(str)) {
                    if (map.get(str) == 3) continue;
                    map.put(str, map.get(str) + 1);
                } else
                    map.put(str, 1);
                mbti.add(str);
            }
            int dist = Integer.MAX_VALUE;
            for (int i = 0; i < mbti.size(); i++) {
                for (int j = 0; j < mbti.size(); j++) {
                    if (i == j) continue;
                    for (int k = 0; k < mbti.size(); k++) {
                        if (i == k || j == k) continue;
                        dist = Math.min(dist, getDist(i, j, k));
                    }
                }
            }
            System.out.println(dist);
        }
    }

    private int getDist(int a, int b, int c) {
        int sum = 0;
        sum += compare(mbti.get(a), mbti.get(b));
        sum += compare(mbti.get(a), mbti.get(c));
        sum += compare(mbti.get(b), mbti.get(c));
        return sum;
    }

    private int compare(String a, String b) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i))
                res++;
        }
        return res;
    }
}
