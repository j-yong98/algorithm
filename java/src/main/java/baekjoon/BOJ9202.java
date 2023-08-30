package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ9202 {
    final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    final int N = 4;
    int W, B;
    TrieNode root = new TrieNode();
    char[][] boggle = new char[N][N];
    boolean[][] visited = new boolean[N][N];
    String[] answers;
    Map<String, Integer> index = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    /**
     * Boggle
     * 트라이 문제
     * 해당 보드에서 문자를 최대 8개 조합 후
     * 트라이에서 매칭 되는 문자 찾기.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        W = Integer.parseInt(br.readLine());
        answers = new String[W];
        for (int w = 0; w < W; w++) {
            String line = br.readLine();
            index.put(line, w);
            insert(line);
        }
        br.readLine();
        B = Integer.parseInt(br.readLine());
        StringBuilder ansSb = new StringBuilder();
        for (int b = 0; b < B; b++) {
            Arrays.fill(answers, "");
            for (int i = 0; i < N; i++)
                boggle[i] = br.readLine().toCharArray();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(boggle[i][j]);
                    visited[i][j] = true;
                    findWord(1, i, j);
                    visited[i][j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            int cnt = 0;
            int score = 0;
            String tmp = "";
            for (String key : index.keySet()) {
                int idx = index.get(key);
                if (answers[idx].isEmpty()) continue;

                score += getScore(answers[idx]);
                if (tmp.length() < answers[idx].length()) {
                    tmp = answers[idx];
                } else if (tmp.length() == answers[idx].length()) {
                    if (tmp.compareTo(answers[idx]) > 0)
                        tmp = answers[idx];
                }

                cnt += 1;
            }
            ansSb.append(score).append(" ").append(tmp).append(" ").append(cnt).append("\n");
            br.readLine();
        }
        System.out.print(ansSb);
        br.close();
    }

    private void findWord(int pick, int y, int x) {
        contains(sb.toString());
        if (pick == 8)
            return;
        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx) || visited[yy][xx]) continue;
            sb.append(boggle[yy][xx]);
            visited[yy][xx] = true;
            findWord(pick + 1, yy, xx);
            visited[yy][xx] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    private boolean contains(String word) {
        if (isWord(root, word)) {
            int idx = index.get(word);
            answers[idx] = word;
            return true;
        }
        return false;
    }

    private int getScore(String word) {
        if (word.length() <= 2) return 0;
        if (word.length() <= 4) return 1;
        if (word.length() == 5) return 2;
        if (word.length() == 6) return 3;
        if (word.length() == 7) return 5;
        if (word.length() == 8) return 11;
        return 0;
    }

    private boolean isWord(TrieNode parent, String word) {
        TrieNode cur = parent;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.child.containsKey(c)) return false;
            cur = cur.child.get(c);
        }

        return cur.isLast;
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
