package baekjoon;

import java.io.*;

public class BOJ7570 {
    final int MAX = 1_000_000;
    int n;
    int[] arr = new int[MAX + 1];
    /**
     * 줄 세우기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(line[i - 1]);
            arr[v] = arr[v - 1] + 1;
            ans = Math.max(ans, arr[v]);
        }
        bw.write( (n - ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    /**
     * 1 2 3 4 5
     * 정렬 되어 있는 상태에서 최장길이는 5가 되므로 답은 5 - 5
     * 1 2 4 5 3
     * 4와 5만을 이동하면 된다
     * 그렇기 때문에 5 - 2
     *
     * 최장 길이 배열을 1씩 증가 시키면 최소한의 이동을 찾아낼 수 있다.
     */
}
