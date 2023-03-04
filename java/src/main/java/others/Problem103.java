package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem103 {
    int n;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    //처음 등장하는 위치
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (map.containsKey(k)) continue;
            else map.put(k, i);
        }
        Iterator<Map.Entry<Integer, Integer>> entry = map.entrySet().iterator();
        while(entry.hasNext()) {
            Map.Entry<Integer, Integer> e = entry.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
