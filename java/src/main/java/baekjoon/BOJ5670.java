package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ5670 {
    int N;
    TrieNode root;
    String[] words;

    /**
     * 휴대폰 자판
     * 트라이 문제
     * 트라이 구성 후
     * 각 단어를 트라이에 넣고 돌리는데
     * 트라이가 마지막 글자거나 갈래길이라면 카운팅 해준다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            root = new TrieNode();
            N = Integer.parseInt(line);
            words = new String[N];
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words[i] = word;
                insert(word);
            }

            int sum = 0;
            for (int i = 0; i < N; i++)
                sum += getCount(words[i]);
            sb.append(String.format("%.2f", ((double) sum) / N)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int getCount(String word) {
        TrieNode cur = root;
        int cnt = 1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (i != 0 && (cur.isLast || cur.child.size() > 1))
                cnt++;

            cur = cur.child.get(c);
        }
        return cnt;
    }

    private void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!cur.child.containsKey(c))
                cur.child.put(c, new TrieNode());

            cur = cur.child.get(c);
        }

        cur.isLast = true;
    }
    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isLast;

        public TrieNode() {
            child = new HashMap<>();
        }
    }
}
