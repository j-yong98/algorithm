package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13505 {
    final int MAX = 30;
    int N;
    int[] arr;
    Trie root = new Trie();
    /**
     * 두 수 XOR
     * XOR하여 가장 큰 수가 되려면 서로 다른 비트가 가장 많아야한다.
     * 숫자를 30자리(최대 10억이기 때문에)이진법으로 변환한 뒤 트라이 구조로 저장 후
     * 숫자 하나씩 XOR연산을 해주는데 자신과 다른 비트가 있다면 해당 비트를 취하고 그게 아니면 원래 비트를 타고 내려간다.
     * 이후 최대값 비교
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            insert(arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, XOR(arr[i]));
        }
        System.out.println(ans);
        br.close();
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

    private void insert(int num) {
        Trie cur = root;

        for (int i = MAX; i >= 0; i--) {
            int bit = num & (1 << i);

            bit = bit == 0 ? 0 : 1;
            if (cur.child[bit] == null)
                cur.child[bit] = new Trie();

            cur = cur.child[bit];
        }
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

    static class Trie {
        Trie[] child;

        public Trie() {
            child = new Trie[2];
        }
    }
}
