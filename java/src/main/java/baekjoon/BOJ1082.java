package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1082 {
    int N;
    int[] arr;
    int M;

    /**
     * 방 번호
     * 그리디 기법으로 해결
     * 우선 처음에 0이 아닌 수중 제일 싼 숫자를 찾는다 -> 0이 앞에오면 0이기 때문이다.
     * 다음으로 0부터 가장 싼 숫자를 찾는다. -> 숫자의 길이가 제일 길어야 하기 때문에 현재 가진 돈에서 가장 길게 만들 수 있어야 하기 때문이다.
     * 해당 숫자로 우선 제일 긴 숫자를 만들어준다.
     * 이후 한자리씩 확인하며 큰 숫자로 바꿀 수 있으면 바꿔준다.
     * 유의할 사항은 N = 1일 경우와 1번과 2번의 값이 같은 경우이다. 또한 답이 0인 상황을 생각해 예외 처리를 해주어야 한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        int fee = M;
        int oneMinCost = 0;
        if (N > 1) {
            oneMinCost = getMinCost(1);
            if (fee < arr[oneMinCost]) {
                System.out.println(0);
                return;
            } else {
                fee -= arr[oneMinCost];
                sb.append(oneMinCost);
            }
        }
        int zeroMinCost = getMinCost(0);

        if (zeroMinCost == oneMinCost) {
            sb.setLength(0);
            fee += arr[oneMinCost];
        }

        while (fee >= arr[zeroMinCost]) {
            sb.append(zeroMinCost);
            fee -= arr[zeroMinCost];
        }

        if (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        for (int i = 0; i < sb.length(); i++) {
            int idx = sb.charAt(i) - '0';
            for (int j = N - 1; j >= 0; j--) {
                if (idx >= j) continue;
                if (arr[j] <= fee + arr[idx]) {
                    fee += arr[idx];
                    sb.setCharAt(i, (char) (j + '0'));
                    fee -= arr[j];
                    break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    private int getMinCost(int start) {
        int minCost = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = start; i < N; i++) {
            if (minCost > arr[i]) {
                minCost = arr[i];
                idx = i;
            } else if (minCost == arr[i])
                idx = Math.max(i, idx);
        }
        return idx;
    }

    class Node {
        int idx;
        int quantity;

        public Node(int idx, int quantity) {
            this.idx = idx;
            this.quantity = quantity;
        }
    }
}