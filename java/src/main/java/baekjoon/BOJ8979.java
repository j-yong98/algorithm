package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ8979 {
    int N, K;
    List<Country> countries = new ArrayList<>();

    /**
     * 올림픽
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int sliver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(idx, gold, sliver, bronze));
        }
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.gold == o2.gold) {
                    if (o1.sliver == o2.sliver)
                        return o2.bronze - o1.bronze;
                    return o2.sliver - o1.sliver;
                }
                return o2.gold - o1.gold;
            }
        });
        int rank = 1;
        countries.get(0).rank = rank++;
        for (int i = 1; i < N; i++) {
            Country a = countries.get(i - 1);
            Country b = countries.get(i);
            if (a.gold == b.gold && a.sliver == b.sliver && a.bronze == b.bronze) {
                b.rank = a.rank;
            } else {
                b.rank = rank;
            }
            rank++;
        }
        for (int i = 0; i < N; i++) {
            if (!(K == countries.get(i).idx)) continue;
            System.out.println(countries.get(i).rank);
            break;
        }
    }

    static class Country {
        int idx;
        int gold;
        int sliver;
        int bronze;
        int rank;

        public Country(int idx, int gold, int sliver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.sliver = sliver;
            this.bronze = bronze;
        }
    }
}
