package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2800 {
    String exp;
    boolean[] visited;
    int[] pair;
    StringBuilder sb = new StringBuilder();
    Set<String> set = new HashSet<>();

    /**
     * 괄호 제거
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
        int len = exp.length();

        Stack<Integer> s = new Stack<>();
        pair = new int[len];
        visited = new boolean[len];

        Arrays.fill(pair, -1);
        for (int i = 0; i < len; i++) {
            if (exp.charAt(i) == '(')
                s.push(i);
            else if (exp.charAt(i) == ')') {
                Integer pop = s.pop();
                pair[i] = pop;
                pair[pop] = i;
            }
        }
        dfs(0, len);
        set.remove(exp);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }

    private void dfs(int l, int len) {
        if (l == len) {
            set.add(sb.toString());
            return;
        }
        if (exp.charAt(l) == '(') {
            visited[l] = true;
            dfs(l + 1, len);
            visited[l] = false;
        }
        if (exp.charAt(l) == ')' && visited[pair[l]]) {
            visited[l] = true;
            dfs(l + 1, len);
            visited[l] = false;
        } else {
            sb.append(exp.charAt(l));
            dfs(l + 1, len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
