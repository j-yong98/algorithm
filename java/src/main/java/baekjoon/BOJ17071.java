package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ17071 {
    final int MAX = 500_000;
    int N, K;
    /**
     * 숨바꼭질 5
     * N부터 출발을 해서 K는 시간 초의 합으로 좌표를 이동한다. N == K가 만나는 시간을 return
     * N은 +1 -1 *2로 1초 후 이동 할 수 있고 해당 지점을 짝수 초에 들렸다면 이후에 또 2초 뒤 돌아올 수 있다.
     * 2초뒤 돌아오는 것을 전부 큐에 넣어버리면 메모리 초과다.
     * 그렇기 때문에 방문 표시를 하 돼 K가 해당 지점을 들렸을 때 N이 그 지점을 먼저 들렸다면 +1 -1을 반복하면서 다시 돌아올 수 있음을 의미 하므로
     * 방문체크 후 홀수 초 짝수 초를 가지고 판별 하면 된다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        System.out.println(bfs());
        br.close();
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[MAX + 1][2];

        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            int kPos = K + ((pos[1] * (pos[1] + 1)) / 2);
            if (kPos > MAX) return -1;
            if (kPos == pos[0] || visited[kPos][pos[1] % 2]) return pos[1];

            if (pos[0] + 1 <= MAX && !visited[pos[0] + 1][(pos[1] + 1) % 2]) {
                visited[pos[0] + 1][(pos[1] + 1) % 2] = true;
                q.add(new int[]{pos[0] + 1, pos[1] + 1});
            } if (pos[0] - 1 >= 0 && !visited[pos[0] - 1][(pos[1] + 1) % 2]) {
                visited[pos[0] - 1][(pos[1] + 1) % 2] = true;
                q.add(new int[]{pos[0] - 1, pos[1] + 1});
            } if (pos[0] * 2 <= MAX && !visited[pos[0] * 2][(pos[1] + 1) % 2]) {
                visited[pos[0] * 2][(pos[1] + 1) % 2] = true;
                q.add(new int[]{pos[0] * 2, pos[1] + 1});
            }
        }
        return -1;
    }
}
