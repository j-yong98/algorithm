package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ14725 {
    int N;
    Trie trie = new Trie();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] words = new String[n];
            for (int j = 0; j < n; j++)
                words[j] = st.nextToken();
            trie.insert(words);
        }
        StringBuilder sb = new StringBuilder();
        trie.printAll(0, trie.root, sb);
        System.out.print(sb);
        br.close();
    }
    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] words) {
            TrieNode cur = root;

            for (int i = 0; i < words.length; i++) {
                if (!cur.child.containsKey(words[i]))
                    cur.child.put(words[i], new TrieNode());
                cur = cur.child.get(words[i]);
            }
            cur.isLast = true;
        }

        public void printAll(int depth, TrieNode parent, StringBuilder sb) {
            if (parent.child.isEmpty()) return;

            for (String key : parent.child.keySet()) {
                for (int i = 0; i < depth; i++)
                    sb.append("--");
                sb.append(key).append("\n");
                printAll(depth + 1, parent.child.get(key), sb);
            }
        }
    }
    static class TrieNode {
        TreeMap<String, TrieNode> child;
        boolean isLast;

        public TrieNode() {
            child = new TreeMap<>();
        }
    }
}
