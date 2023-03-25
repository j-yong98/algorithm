package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3190 {
    int n, k;
    int l;
    int[] dy = {0, -1, 0, 1};
    int[] dx = {1, 0, -1, 0};
    char[] dir = new char[10001];
    int move = 0;
    List<int[]> apple = new ArrayList<>();
    Deque<int[]> snake = new ArrayDeque<>();
    int t = 0;

    private boolean inRange(int y, int x) {
        return y > 0 && y <= n && x > 0 && x <= n;
    }

    private boolean collision() {
        int[] head = snake.pollFirst();
        if (!inRange(head[0], head[1]))
            return true;
        for (int[] pos : snake) {
            if (pos[0] == head[0] && pos[1] == head[1])
                return true;
        }
        snake.addFirst(head);
        return false;
    }
    private boolean appleCheck(int y, int x) {
        for (int[] pos : apple) {
            if (pos[0] == y && pos[1] == x) {
                apple.remove(pos);
                return true;
            }
        }
        return false;
    }
    private void simulate() {
        while (true) {
            t++;
            int[] head = snake.peek();
            snake.addFirst(new int[]{head[0] + dy[move], head[1] + dx[move]});
            if (collision())
                break;
            if (!appleCheck(head[0] + dy[move], head[1] + dx[move]))
                snake.pollLast();
            if (dir[t] == 'L') {
                move = (move + 1) % 4;
            }
            else if(dir[t] == 'D') {
                move = (move + 3) % 4;
            }
        }
    }

    /**
     * 뱀
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple.add(new int[]{r, c});
        }
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            dir[time] = d;
        }
        snake.add(new int[]{1, 1});
        simulate();
        System.out.println(t);
    }
}
