package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ8547 {
    final int MAX = 100_000;
    int N;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    Map<Integer, Node> map = new HashMap<>();
    int[] count;
    int cnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[MAX + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            count[val] += 1;
        }
        for (int i = 1; i <= MAX; i++) {
            if (count[i] > 0) {
                Node node = new Node(i, count[i]);
                pq.add(node);
                map.put(i, node);
            }
        }

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (tmp.cnt == 1) {
                cnt += 1;
                continue;
            }
            int n = tmp.val * 2;
            tmp.cnt -= 2;
            if (map.containsKey(n))
                map.get(n).cnt += 1;
            else {
                map.put(n, new Node(n, 1));
                pq.add(map.get(n));
            }
            if (tmp.cnt == 0)
                map.remove(tmp.val);
            else
                pq.add(tmp);
        }

        System.out.println(cnt);
    }

    static class Node {
        int val;
        int cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
