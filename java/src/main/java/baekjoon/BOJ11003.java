package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11003 {
    int N, L;
    int[] arr;
    Deque<Integer> q = new ArrayDeque<>();
    /**
     * 최솟값 찾기
     * 큐를 이용한 풀이
     * 원소의 인덱스를 큐에 저장을 하고
     * 큐의 제일 뒤에 배열 값이 들어올 값보다 크다면 제거 해준다.
     * 그리고 제일 뒤에 현재 값을 넣어준다
     * 제일 앞에 있는 인덱스가 현재 인덱스(i - L)보다 작다면 제거 해준다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while (!q.isEmpty() && arr[q.getLast()] > arr[i]) q.pollLast();
            q.offerLast(i);
            if (!q.isEmpty() && q.getFirst() <= i - L) q.pollFirst();
            sb.append(arr[q.getFirst()]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
