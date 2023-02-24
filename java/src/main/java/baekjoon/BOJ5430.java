package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ5430 {
    int T;
    int n;
    String p;
    boolean isRight;
    ArrayDeque q = new ArrayDeque();
    StringBuilder sb;

    /**
     * AC
     * 해당 문제는 자료구조 deque를 이용하면 쉽게 풀이할 수 있다.
     * R은 배열의 구조를 뒤집는 것이고 D는 앞부분의 원소를 삭제하는 것이다.
     * 양쪽에서 삽입 삭제를 할 수 있는 deque를 사용하였다.
     * 처음의 앞은 left이기 때문에 isRight변수를 false로 두고
     * 이후에 R이 나오면 반전시켰다.
     * 이를 통해 queue구조의 앞단을 어디인지 알 수 있고
     * isRight변수를 토대로 삭제와 출력을 하였다.
     */
    public boolean AC() {
        isRight = false;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'R') {
                isRight = isRight == false ? true : false;
            }
            else {
                if (q.isEmpty()) return false;
                if (isRight)
                    q.pollLast();
                else
                    q.poll();
            }
        }
        return true;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            q.clear();
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                q.add(st.nextToken());
            }
            if (AC()) {
                sb.append("[");
                while (!q.isEmpty()) {
                    if (isRight)
                        sb.append(q.pollLast());
                    else
                        sb.append(q.pollFirst());
                    if (q.size() != 0)
                        sb.append(",");
                }
                sb.append("]");
            }
            else
                sb.append("error");
            System.out.println(sb);
        }
    }
}
