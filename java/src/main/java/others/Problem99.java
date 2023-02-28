package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem99 {
    int n, k;
    int[] arr;
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * n개의 숫자 3개를 더해 k가 되는 경우의 수
     * 숫자의 위치가 다르면 다른 경우로 간주한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = k - (arr[i] + arr[j]);
                if (map.containsKey(key))
                    ans += map.get(key);
            }
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }
        System.out.println(ans);
    }
}
