package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16562 {
    final int MAX = 100_000_000;
    int N, M, K;
    int[] arr;
    int[] cost;
    int[] count;

    /**
     * 친구비
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        cost = new int[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            arr[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        //부분 집합의 최솟값의 합
        int ans = 0;
        int[] res = new int[N + 1];
        Arrays.fill(res, MAX);
        for (int i = 1; i <= N; i++) {
            int p = findParent(i);
            res[p] = Math.min(res[arr[p]], cost[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (res[i] == MAX) continue;
            ans += res[i];
        }
        System.out.println(ans > K ? "Oh no" : ans);
    }

    private boolean allFriend(boolean[] visited) {
        for (int i = 1; i <= N; i++)
            if (!visited[i]) return false;
        return true;
    }

    private int findParent(int a) {
        if (a == arr[a]) return a;
        return findParent(arr[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            if (p1 < p2)
                arr[p2] = p1;
            else
                arr[p1] = p2;
        }
    }
}
