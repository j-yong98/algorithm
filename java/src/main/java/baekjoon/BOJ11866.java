package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11866 {
    int n, k;
    Deque<Integer> dq = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    /**
     * 요세푸스 문제
     * 1~n까지 나열된 원형에서 k번째의 사람을 계속해서 제거했을 때의 순서를 출력하는 문제이다.
     * deque를 이용해서 모든 원소를 출력할 때까지 반복한다.
     * k-1번을 큐 앞의 원소를 뒤로 다시 삽입한다.
     * k번째 원소를 출력한다.
     * 반복한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }
        sb.append("<");
        while (!dq.isEmpty()) {
            for (int i = 1; i <= k - 1; i++) {
                dq.addLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst());
            if (!dq.isEmpty())
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
