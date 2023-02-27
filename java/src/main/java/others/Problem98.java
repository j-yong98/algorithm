package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem98 {
    int n, k;
    Map<Integer, Integer> map = new HashMap<>();
    int[] arr;
    /**
     * 두 수의 합
     * 주어진 수들 중 서로 다른 위치에 있는 두 개의 수를 골랐을 때 합이 k가 되는 가짓수 출력
     */
    public int solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            if (map.containsKey(k))
                map.put(k, map.get(k) + 1);
            else map.put(k, 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int key = k - arr[i];
            if (map.containsKey(key)) {
                map.put(arr[i], map.get(arr[i]) - 1);
                ans += map.get(key) <= 0 ? 0 : map.get(key);
            }
        }
        System.out.println(ans);
        return ans;
    }
}
