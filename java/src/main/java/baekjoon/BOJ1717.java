package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    int N, M;
    int[] arr;

    /**
     * 집합의 표현
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++)
            arr[i] = i;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0)
                union(a, b);
            else {
                if (findParent(a) == findParent(b)) {
                    sb.append("YES").append("\n");
                } else sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
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
