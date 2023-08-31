package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16903 {

    int N;
    int[] arr;
    Trie root;
    final int MAX = 31;

    /**
     * 수열과 쿼리 20
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        root = new Trie();
        insert(0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) insert(Integer.parseInt(st.nextToken()));
            else if (cmd == 2) delete(root, MAX, Integer.parseInt(st.nextToken()));
            else sb.append(XOR(Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private void printAll(Trie trie, int idx, StringBuilder sb) {
        if (idx == MAX + 1) {
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (trie.child[i] == null) continue;
            sb.append(i);
            printAll(trie.child[i], idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private int XOR(int num) {
        Trie cur = root;

        int res = 0;
        for (int i = MAX; i >= 0; i--) {
            int bit = num & (1 << i);

            bit = bit == 0 ? 0 : 1;
            if (cur.child[bit ^ 1] != null) {
                res += (1 << i);
                bit ^= 1;
            }

            cur = cur.child[bit];
        }

        return res;
    }

    private void delete(Trie cur, int idx, int num) {
        if (idx == -1)
            return;

        int bit = num & (1 << idx);

        bit = bit == 0 ? 0 : 1;
        delete(cur.child[bit], idx - 1, num);
        cur.child[bit].cnt -= 1;
        if (cur.child[bit].cnt == 0)
            cur.child[bit] = null;
    }

    void insert(int num) {
        Trie cur = root;

        for (int i = MAX; i >= 0; i--) {
            int bit = num & (1 << i);

            bit = bit == 0 ? 0 : 1;
            if (cur.child[bit] == null)
                cur.child[bit] = new Trie();

            cur.child[bit].cnt += 1;
            cur = cur.child[bit];
        }
    }

    class Trie {
        Trie[] child;
        int cnt;

        public Trie() {
            child = new Trie[2];
        }
    }
}
