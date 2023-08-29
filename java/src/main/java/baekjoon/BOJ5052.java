package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ5052 {
    int T;
    int N;
    String[] numbers;

    /**
     * 전화번호 목록
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Trie trie = new Trie();
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                trie.insert(line);
                numbers[i] = line;
            }
            boolean consistency = true;
            for (int i = 0; i < N; i++) {
                if (!trie.check(trie.root, numbers[i], 0)) {
                    consistency = false;
                    break;
                }
            }

            if (consistency)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        br.close();
    }
    static class TrieNode {
        Map<Character, TrieNode> childNode;
        boolean isLast;

        public TrieNode() {
            childNode = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!cur.childNode.containsKey(ch))
                    cur.childNode.put(ch, new TrieNode());
                cur = cur.childNode.get(ch);
            }

            cur.isLast = true;
            return true;
        }

        public boolean check(TrieNode node, String word, int idx) {
            if (idx == word.length())
                return true;
            if (node.isLast) return false;

            char ch = word.charAt(idx);
            return check(node.childNode.get(ch), word, idx + 1);
        }

        public boolean find(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.childNode.containsKey(ch)) return false;
                cur = cur.childNode.get(ch);
            }

            return cur.isLast;
        }

        public void delete(String word) {
            delete(root, word, 0);
        }

        private void delete(TrieNode cur, String word, int idx) {
            if (idx == word.length()) {
                if (!cur.isLast) throw new IllegalArgumentException();
                cur.isLast = false;
                return;
            }
            char ch = word.charAt(idx);
            if (!cur.childNode.containsKey(ch)) throw new IllegalArgumentException();
            TrieNode child = cur.childNode.get(ch);
            delete(child, word, idx + 1);
            if (child.childNode.isEmpty())
                if (!child.isLast) cur.childNode.remove(ch, child);
        }
    }
}
