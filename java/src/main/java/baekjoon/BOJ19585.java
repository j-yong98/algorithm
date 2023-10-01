package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ19585 {
    int C, N;
    int Q;
    Trie colors = new Trie();
    Set<String> nickNames = new HashSet();
    Map<String, List<Integer>> res = new HashMap<>();
    List<String> q = new ArrayList<>();

    /**
     * 전설
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < C; i++) {
            String color = br.readLine();
            insert(colors, color);
        }

        for (int i = 0; i < N; i++) {
            String nickName = br.readLine();
            nickNames.add(nickName);
        }

        Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String teamName = br.readLine();
            q.add(teamName);
            res.put(teamName, new ArrayList<>());
            int len = teamName.length();
            queryColor(teamName, len);
        }
        for (String key : q) {
            List<Integer> tmp = res.get(key);
            boolean flag = false;
            if (!tmp.isEmpty()) {
                for (int len : tmp) {
                    if (nickNames.contains(key.substring(len))) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                sb.append('Y').append('e').append('s').append('\n');
            else
                sb.append('N').append('o').append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    private void queryColor(String str, int len) {
        Trie cur = colors;
        for (int i = 0; i < len; i++) {
            if (cur.isLast) res.get(str).add(i);
            char c = str.charAt(i);
            if (cur.child[c - 'a'] == null) return;
            cur = cur.child[c - 'a'];
        }
    }

    private void insert(Trie root, String str) {
        Trie cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.child[c - 'a'] == null)
                cur.child[c - 'a'] = new Trie();
            cur = cur.child[c - 'a'];
        }
        cur.isLast = true;
    }

    static class Trie {
        Trie[] child;
        boolean isLast;

        public Trie() {
            child = new Trie[26];
        }
    }
}
