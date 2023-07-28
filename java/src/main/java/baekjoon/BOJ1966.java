package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {
    int T;
    int n, m;
    /**
     * 프린터 큐
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            LinkedList<Document> q = new LinkedList<>();
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                q.add(new Document(i, Integer.parseInt(line[i])));
            int cnt = 0;
            while (!q.isEmpty()) {
                int max = 0;

                for (int i = 0; i < q.size(); i++) {
                    max = Math.max(max, q.peek().priority);
                    q.addLast(q.pollFirst());
                }

                if (q.peek().priority == max) {
                    cnt++;
                    if (q.peek().idx == m)
                        break;
                    else q.pollFirst();
                }
                else q.addLast(q.pollFirst());
            }

            System.out.println(cnt);
        }
        br.close();
    }

    static class Document {
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
