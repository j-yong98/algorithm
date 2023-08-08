package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ7662 {
    int T;
    int N;

    /**
     * 이중 우선순위 큐
     * 우선순위 큐 두개 선언 후
     * 넣을 때 인덱스와 함께 넣어서 삭제 처리
     */
    public void solution() throws IOException {
//        System.setIn(new FileInputStream("01.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Node> maxPq = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
            PriorityQueue<Node> minPq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
            boolean[] deleted = new boolean[N];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                if (line[0].equals("I")) {
                    int num = Integer.parseInt(line[1]);
                    minPq.add(new Node(i, num));
                    maxPq.add(new Node(i, num));
                } else {
                    int selected = Integer.parseInt(line[1]);
                    if (selected == 1) {
                        while (!maxPq.isEmpty()) {
                            Node node = maxPq.poll();
                            if (deleted[node.idx]) continue;
                            deleted[node.idx] = true;
                            break;
                        }
                    } else {
                        while (!minPq.isEmpty()) {
                            Node node = minPq.poll();
                            if (deleted[node.idx]) continue;
                            deleted[node.idx] = true;
                            break;
                        }
                    }
                }
            }
            int max = 0, min = 0;
            boolean maxEmpty = true, minEmpty = true;
            while (!minPq.isEmpty()) {
                Node node = minPq.poll();
                if (deleted[node.idx]) continue;
                minEmpty = false;
                min = node.value;
                break;
            }
            while (!maxPq.isEmpty()) {
                Node node = maxPq.poll();
                if (deleted[node.idx]) continue;
                maxEmpty = false;
                max = node.value;
                break;
            }
            if (maxEmpty && minEmpty)
                sb.append("EMPTY\n");
            else if (!maxEmpty && minEmpty)
                sb.append(max).append(" ").append(max).append("\n");
            else if (maxEmpty && !minEmpty)
                sb.append(min).append(" ").append(min).append("\n");
            else
                sb.append(max).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
