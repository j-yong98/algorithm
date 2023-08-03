package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ12891 {
    int N, M;
    int ans = 0;
    int[] cnt = new int[4];
    Map<Character, Integer> map = new HashMap<>();
    String dna;

    /**
     * DNA 비밀번호
     * subString으로 개수를 확인 했으나 시간 초과
     * 시작점 0부터 M부터 한칸씩 이동할 때 왼쪽의 문자 count는 -1 오른쪽 문자의 count는 +1을 해주고 문자의 카운트가 이상이면 ans++
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        dna = br.readLine();

        line = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            cnt[i] = Integer.parseInt(line[i]);

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int[] res = new int[4];
        for (int i = 0; i < M; i++)
            res[map.get(dna.charAt(i))]++;

        int i = 0;
        int j = M - 1;

        while (true) {
            if (check(res)) ans++;
            res[map.get(dna.charAt(i++))]--;
            if (++j == N) break;
            res[map.get(dna.charAt(j))]++;
        }
        System.out.println(ans);
    }
    private boolean check(int[] res) {
        for (int i = 0; i < 4; i++)
            if (res[i] < cnt[i]) return false;
        return true;
    }
}
