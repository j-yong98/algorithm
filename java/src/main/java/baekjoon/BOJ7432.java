package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ7432 {
    int N;
    Trie root = new Trie();
    StringBuilder sb = new StringBuilder();

    /**
     * 디스크 트리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split("\\\\");
            insert(words);
        }

        printAll(root, 0);
        System.out.println(sb);
        br.close();
    }

    private void printAll(Trie cur, int depth) {
        if (cur.child.isEmpty())
            return;

        for (String word : cur.child.keySet()) {
            for (int i = 0; i < depth; i++)
                sb.append(" ");
            sb.append(word).append("\n");
            printAll(cur.child.get(word), depth + 1);
        }
    }

    private void insert(String[] words) {
        Trie cur = root;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (!cur.child.containsKey(word))
                cur.child.put(word, new Trie());

            cur = cur.child.get(word);
        }
    }
    class Trie {
        Map<String, Trie> child;

        public Trie() {
            child = new TreeMap<>();
        }
    }
}
