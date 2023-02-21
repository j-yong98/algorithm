package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1655 {
    int n;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (minHeap.size() == maxHeap.size())
                maxHeap.add(num);
            else
                minHeap.add(num);
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
/**
 * 이 문제는 중간 수를 출력하는 문제이다.
 * 하지만 매번 입력 받을 때 마다 정렬 시키면 시간 초과가 나게 된다.
 * 최대힙과 최소힙 두 개를 두고
 * 두 개의 수 차이를 1이하로 두고 최소힙의 top 값이 항상 최대힙의 top 보다 크도록 유지해준다.
 * 그 이후에 최대힙의 top 값을 출력하면 된다.
 * ex)
 * 최대힙                  최소힙
 * 1
 * 1                     5
 * 1 2                   5
 * 1 2                   5 10
 * -99 1 2               5 10
 * -99 1 2               5 7 10
 * -99 1 2 5             5 7 10
 * 이런 식으로 항상 최소힙의 top값이 최대힙의 top 값보다 크게 유지해주면 중간 값이 최대힙의 top값이 되는 것을 확인 할 수 있다.
 */
