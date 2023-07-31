package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ21315 {
    int n;
    int[] ans;

    /**
     * 카드 섞기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            ans[i] = Integer.parseInt(st.nextToken());

        int limit = 1;
        while (Math.pow(2, limit) <= n)
            limit++;
        for (int i = 1; i < limit; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            IntStream.iterate(1, a -> a + 1).limit(n).forEach(a -> q.add(a));
            for (int j = 1; j < limit; j++) {
                Deque<Integer> res = mix(mix(q, i), j);
                if (isEqual(ans, res.stream().mapToInt(Integer::intValue).toArray())) {
                    System.out.println(i + " " + j);
                    System.exit(0);
                }
            }
        }
    }

    private Deque<Integer> mix(Deque<Integer> q, int k) {
        Deque<Integer> tmp = new ArrayDeque<>(q);
        int cnt = (int) Math.pow(2,  k);
        for (int i = 0; i < cnt; i++)
            tmp.addFirst(tmp.pollLast());
        for (int i = 2; i <= k + 1; i++) {
            int base = k - i + 1;
            int calc = (int) Math.pow(2, base);
            int size = tmp.size();
//			옮긴 것 중 calc개가 앞으로 와야함
//			cnt - calc 개를 다른 큐에 넣어야함
            Deque<Integer> left = new ArrayDeque<>();
            Deque<Integer> right = new ArrayDeque<>();

            for (int j = 0; j < cnt - calc; j++)
                left.add(tmp.pollFirst());
            for (int j = 0; j < size - cnt; j++)
                right.add(tmp.pollLast());

            while (!left.isEmpty())
                tmp.add(left.pollFirst());
            while (!right.isEmpty())
                tmp.add(right.pollLast());
            cnt = calc;
        }
        return tmp;
    }

    private boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
