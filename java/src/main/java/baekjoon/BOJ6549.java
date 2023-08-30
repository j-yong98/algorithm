package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6549 {
    int N;
    Stack<Node> s;
    long ans;

    /**
     * 히스토그램에서 가장 큰 직사각형
     * 스택 활용 문제
     * 들어오는 숫자를 오름차순으로 스택에 저장한다.
     * 현재 들어올 숫자가 top의 숫자보다 작다면
     * 해당 숫자의 크기보다 큰 숫자들은 모두 직사각형으로 만들 수 있기 때문에
     * 스택에서 해당 숫자보다 작을 때까지 꺼내주면서 들어갈 숫자에 개수를 더해주고 꺼내는 숫자의 크기 비교 갱신.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            ans = 0;
            s = new Stack<>();
            for (int i = 0; i < N; i++) {
                long height = Long.parseLong(st.nextToken());
                Node now = new Node(height, 1);
                long pre = 0;
                while (!s.isEmpty()) {
                    Node top = s.peek();
                    if (top.height < height) {
                        s.push(now);
                        ans = Math.max(ans, pre * (now.cnt - 1));
                        break;
                    }
                    else {
                        Node pop = s.pop();
                        pre = pop.height;
                        now.cnt += pop.cnt;
                        ans = Math.max(ans, pre * (now.cnt - 1));
                    }
                }
                if (s.isEmpty())
                    s.push(now);
            }
            while (!s.isEmpty()) {
                Node pop = s.pop();
                if (!s.isEmpty())
                    s.peek().cnt += pop.cnt;
                ans = Math.max(ans, pop.cnt * pop.height);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Node {
        long height;
        int cnt;

        public Node(long height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}
