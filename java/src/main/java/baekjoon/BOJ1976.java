package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {
    int N, M;
    int[] arr;

    /**
     * 여행 가자
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1)
                    union(i, j);
            }
        }

        boolean ans = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = start; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (findParent(start - 1) != findParent(next - 1)) {
                ans = false;
                break;
            }
            start = next;
        }
        System.out.println(ans ? "YES" : "NO");
    }

    private int findParent(int a) {
        if (a == arr[a]) return a;
        return findParent(arr[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2)
            arr[p2] = p1;
    }
}
