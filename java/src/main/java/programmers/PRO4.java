package programmers;

import java.util.Stack;

public class PRO4 {
    Stack<Integer> dStack = new Stack<>();
    Stack<Integer> pStack = new Stack<>();
    /**
     * 택배 배달과 수거하기
     */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++)
                dStack.add(i + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < pickups[i]; j++)
                pStack.add(i + 1);
        }
        while (!dStack.isEmpty() && !pStack.isEmpty()) {
            int dist1 = dStack.peek();
            int dist2 = pStack.peek();
            for (int i = 0; i < cap; i++) {
                if (!dStack.isEmpty()) dStack.pop();
                if (!pStack.isEmpty()) pStack.pop();
            }
            ans += Math.max(dist1, dist2) * 2L;
        }
        while (!dStack.isEmpty()) {
            int dist = dStack.peek();
            for (int i = 0; i < cap; i++)
                if (!dStack.isEmpty()) dStack.pop();
            ans += dist * 2L;
        }
        while (!pStack.isEmpty()) {
            int dist = dStack.peek();
            for (int i = 0; i < cap; i++)
                if (!pStack.isEmpty()) pStack.pop();
            ans += dist * 2L;
        }
        return ans;
    }
}
/**
 * 2개의 스택을 사용하여 풀이 할 수 있다.
 * 1. 각 스택에 택배와 상자를 개수만큼 넣어 준다.
 * 2. 각 스택에서 cap만큼 빼주며 둘 중 더 큰 거리 값을 (왕복 * 2) 더해준다.
 * 3. 다 배달하지 못한 택배와 수거하지 못한 상자를 처리하여 준다.
 */
