package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ4358 {
    TreeMap<String, Integer> tree = new TreeMap<>();

    /**
     * 생태학
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            if (!tree.containsKey(line))
                tree.put(line, 0);
            tree.put(line, tree.get(line) + 1);
            sum++;
        }
        StringBuilder sb = new StringBuilder();
        for (String name : tree.keySet()) {
            double res = (((double) tree.get(name)) / sum) * 100;
            sb.append(name).append(" ").append(String.format("%.4f", res)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
