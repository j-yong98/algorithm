package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem101 {
    int n;
    Map<String, Integer> map = new HashMap<>();
    int ans;

    /**
     * 순서가 다른 단어 나타난 최고 횟수
     * 순서가 다른 단어이기 때문에 전부 정렬을 해주어 같은 문자로 map에 넣어준 뒤 최대값을 뽑았다.
     */
    public int solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] str = st.nextToken().toCharArray();
            Arrays.sort(str);
            String key = Arrays.toString(str);
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        ans = 0;
        for (Integer value : map.values()) {
            ans = Math.max(ans, value);
        }
        System.out.println(ans);
        return ans;
    }
}
