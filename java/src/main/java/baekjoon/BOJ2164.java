package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class BOJ2164 {
    int n;
    Deque<Integer> q = new ArrayDeque<>();
    /**
     * 카드2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        IntStream.iterate(1, i -> i + 1).limit(n).forEach(i -> q.add(i));
        while (!q.isEmpty() && q.size() > 1) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        System.out.println(q.pollFirst());
        br.close();
    }
}
