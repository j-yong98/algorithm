package baekjoon;

import java.io.*;

public class BOJ4256 {
    int T;
    int n;
    int[][] order;
    StringBuilder sb = new StringBuilder();
    /**
     * 트리
     *
     * 전위 순회를 통해 루트를 알 수 있다.
     * 중위 순회에서 해당 루트의 위치를 찾으면 왼쪽 노드(start ~ root - 1)와 오른쪽 노드(root + 1 ~ end)
     * 전위 순회의 루트를 가지고
     * 중위 순회의 루트 위치를 찾고
     * 왼쪽
     * 오른쪽
     * 순회 후
     * 현재 value 출력을 하게 되면 후위 순회
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            order = new int[2][n];
            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++)
                    order[i][j] = Integer.parseInt(line[j]);
            }
            postOrder(0, n - 1, 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void postOrder(int s, int e, int root) {
        for (int i = s; i <= e; i++) {
            if (order[0][root] == order[1][i]) {
                postOrder(s, i - 1,root + 1);
                postOrder(i + 1, e, root + 1 + i - s);
                sb.append(order[0][root]).append(" ");
                return ;
            }
        }
    }
}
