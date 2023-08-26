package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2931 {
    final char MOSCOW = 'M';
    final char ZAGREB = 'Z';
    final char STRAIGHT_UP_DOWN = '|';
    final char STRAIGHT_LEFT_RIGHT = '-';
    final char CROSS = '+';
    final char BLOCK1 = '1';
    final char BLOCK2 = '2';
    final char BLOCK3 = '3';
    final char BLOCK4 = '4';
    final char[] BLOCKS = {STRAIGHT_UP_DOWN, STRAIGHT_LEFT_RIGHT, BLOCK1, BLOCK2, BLOCK3, BLOCK4, CROSS};

    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int R, C;
    char[][] arr;
    int[] startPos;
    int[] endPos;
    boolean[][] visited;
    List<int[]> roads = new ArrayList<>();

    /**
     * 가스관
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == MOSCOW)
                    startPos = new int[]{i, j};
                else if (arr[i][j] == ZAGREB)
                    endPos = new int[]{i, j};
                else if (isRoad(arr[i][j]))
                    roads.add(new int[]{i, j});
            }
        }
        int[] missingBlock = findBlock();
        if (missingBlock == null) throw new IllegalArgumentException();
        char ans = 0;
        for (int i = 0; i < BLOCKS.length; i++) {
            arr[missingBlock[0]][missingBlock[1]] = BLOCKS[i];
            for (int j = 0; j < R; j++)
                Arrays.fill(visited[j], false);
            if (!canReach() || !allVisited()) continue;
            ans = BLOCKS[i];
            break;
        }
        System.out.println((missingBlock[0] + 1) + " " + (missingBlock[1] + 1) + " " + ans);
        br.close();
    }

    private boolean allVisited() {
        for (int[] road : roads) {
            if (!visited[road[0]][road[1]]) return false;
        }
        return true;
    }

    private boolean canReach() {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            int y = startPos[0] + dy[i];
            int x = startPos[1] + dx[i];
            if (inRange(y, x) && isRoad(arr[y][x]) && canGo(arr[y][x], i)) {
                int nextDir = go(arr[y][x], i);
                q.add(new int[]{y, x, nextDir});
                break;
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            visited[pos[0]][pos[1]] = true;
            int y = pos[0] + dy[pos[2]];
            int x = pos[1] + dx[pos[2]];
            if (!inRange(y, x) || arr[y][x] != ZAGREB && !canGo(arr[y][x], pos[2]))return false;
            if (arr[y][x] == ZAGREB) return true;
            int nextDir = go(arr[y][x], pos[2]);
            q.add(new int[]{y, x, nextDir});
        }
        return false;
    }

    private int[] findBlock() {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            int y = startPos[0] + dy[i];
            int x = startPos[1] + dx[i];
            if (inRange(y, x) && isRoad(arr[y][x]) && canGo(arr[y][x], i)) {
                int nextDir = go(arr[y][x], i);
                q.add(new int[]{y, x, nextDir});
                break;
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            int y = pos[0] + dy[pos[2]];
            int x = pos[1] + dx[pos[2]];
            if (!canGo(arr[y][x], pos[2])) return new int[]{y, x};
            int nextDir = go(arr[y][x], pos[2]);
            q.add(new int[]{y, x, nextDir});
        }
        return null;
    }

    private int go(char c, int dir) {
        if (c == STRAIGHT_UP_DOWN || c == STRAIGHT_LEFT_RIGHT || c == CROSS)
            return dir;
        if (c == BLOCK1) {
            if (dir == 0) return 3;
            if (dir == 2) return 1;
        }
        if (c == BLOCK2) {
            if (dir == 1) return 3;
            if (dir == 2) return 0;
        }
        if (c == BLOCK3) {
            if (dir == 1) return 2;
            if (dir == 3) return 0;
        }
        if (c == BLOCK4) {
            if (dir == 0) return 2;
            if (dir == 3) return 1;
        }
        throw new IllegalArgumentException();
    }

    private boolean canGo(char c, int dir) {
        if (c == STRAIGHT_UP_DOWN) {
            if (dir == 0 || dir == 1) return true;
        } else if (c == STRAIGHT_LEFT_RIGHT) {
            if (dir == 2 || dir == 3) return true;
        } else if (c == CROSS) {
            return true;
        } else if (c == BLOCK1) {
            if (dir == 0 || dir == 2) return true;
        } else if (c == BLOCK2) {
            if (dir == 1 || dir == 2) return true;
        } else if (c == BLOCK3) {
            if (dir == 1 || dir == 3) return true;
        } else if (c == BLOCK4) {
            if (dir == 0 || dir == 3) return true;
        }
        return false;
    }

    private boolean isRoad(char c) {
        return c == STRAIGHT_UP_DOWN || c == STRAIGHT_LEFT_RIGHT || c == CROSS ||
                c == BLOCK1 || c == BLOCK2 || c == BLOCK3 || c == BLOCK4;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
