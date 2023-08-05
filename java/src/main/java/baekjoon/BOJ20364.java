package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ20364 {
    int N, Q;
    int[] tree;
    int[] info;

    /**
     * 부동산 다툼
     * 트리 구조로 자신이 원하는 지역부터 부모로 올라가다 1을 만나면 종료
     * 단 올라갈 때 주의 해야 하는 부분은 문제에서 1부터 내려가다 처음 만난 주인 있는 땅이 있다면 이기 떄문에 올라갈 때 주인이 있는 땅을 큐에 넣어 두고 마지막에 꺼내는 방식으로 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        Q = Integer.parseInt(line[1]);
        tree = new int[N + 1];
        info = new int[N + 1];
        tree[1] = -1;
        for (int i = 1; i <= N; i++) {
            if (i * 2 <= N)
                tree[i * 2] = i;
            if (i * 2 + 1 <= N)
                tree[i * 2 + 1] = i;
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= Q; i++) {
            int want = Integer.parseInt(br.readLine());
            q.clear();
            canGet(want, q);
            if (q.size() == 0) {
                info[want] = i;
                sb.append(0);
            } else sb.append(q.pollFirst());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void canGet(int now, Deque<Integer> q) {
        if (now == 1) return;
        if (info[now] != 0) q.addFirst(now);
        canGet(now / 2, q);
    }
}
