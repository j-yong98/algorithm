package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem171 {
    final int N = 10;
    final int[] DY = {0, -1, 0, 1, 0};
    final int[] DX = {0, 0, 1, 0, -1};
    int T;
    int M, A;
    int[] a;
    int[] b;
    int[] aScore;
    int[] bScore;
    int[] aPos = new int[2];
    int[] bPos = new int[2];
    List<Battery> batteries = new ArrayList<>();

    /**
     * 무선 충전
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input(br);
            int res = start();
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private void input(BufferedReader br) throws IOException {
        batteries.clear();
        aPos[0] = aPos[1] = 1;
        bPos[0] = bPos[1] = N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        a = new int[M + 1];
        b = new int[M + 1];
        aScore = new int[M + 1];
        bScore = new int[M + 1];
        //사용자 이동 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            b[i] = Integer.parseInt(st.nextToken());
        //Battery 입력
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());
            int charge = Integer.parseInt(st.nextToken());
            batteries.add(new Battery(i, y, x, range, charge));
        }
    }
    private int start() {
        for (int i = 0; i <= M; i++) {
            move(a[i], b[i]);
            charging(i);
        }
        return Arrays.stream(aScore).sum() + Arrays.stream(bScore).sum();
    }

    /**
     * 사용자 이동
     */
    private void move(int aDir, int bDir) {
        aPos[0] = aPos[0] + DY[aDir];
        aPos[1] = aPos[1] + DX[aDir];

        bPos[0] = bPos[0] + DY[bDir];
        bPos[1] = bPos[1] + DX[bDir];
    }

    /**
     * 충전 감지
     */
    private void charging(int time) {
        int[] batteryCount = new int[A];
        List<Battery> aBattery = detect(aPos, batteryCount);
        List<Battery> bBattery = detect(bPos, batteryCount);

        aScore[time] = getMaxCharging(aBattery);
        bScore[time] = getMaxCharging(bBattery);

        for (int i = 0; i < A; i++) {
            if (batteryCount[i] > 1) {
                int[] c = getMaxSumCharging(aBattery, bBattery);
                aScore[time] = c[0];
                bScore[time] = c[1];
                break;
            }
        }
    }

    /**
     * 범위 내 배터리 구하기
     */
    private List<Battery> detect(int[] pos, int[] count) {
        List<Battery> inChargingRange = new ArrayList<>();
        for (Battery battery : batteries) {
            if (belongRange(pos, battery)) {
                inChargingRange.add(battery);
                count[battery.id]++;
            }
        }
        return inChargingRange;
    }

    /**
     * 최대 충전 값 구하기
     */
    private int getMaxCharging(List<Battery> batteries) {
        if (batteries.isEmpty()) return 0;

        int max = 0;
        for (Battery battery : batteries)
            max = Math.max(max, battery.charge);
        return max;
    }

    /**
     * 배터리 충전 최대 합 짝 구하기
     */
    private int[] getMaxSumCharging(List<Battery> b1, List<Battery> b2) {
        int[] charge = new int[2];
        for (int i = 0; i < b1.size(); i++) {
            Battery tmp1 = b1.get(i);
            for (int j = 0; j < b2.size(); j++) {
                Battery tmp2 = b2.get(j);
                int amount1 = tmp1.charge;
                int amount2 = tmp2.charge;
                if (tmp1.id == tmp2.id) {
                    amount1 /= 2;
                    amount2 /= 2;
                }
                if (amount1 + amount2 > Arrays.stream(charge).sum()) {
                    charge[0] = amount1;
                    charge[1] = amount2;
                }
            }
        }
        return charge;
    }

    /**
     * bfs를 통한 범위 내에 속한 배터리 감지
     */
    private boolean belongRange(int[] pos, Battery b) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][N + 1];

        q.add(new int[]{b.y, b.x, b.range});
        visited[b.y][b.x] = true;

        while (!q.isEmpty()) {
            int[] r = q.pollFirst();

            if (r[0] == pos[0] && r[1] == pos[1]) return true;

            for (int i = 1; i <= 4; i++) {
                int y = r[0] + DY[i];
                int x = r[1] + DX[i];
                if (!inRange(y, x) || r[2] == 0 || visited[y][x]) continue;
                visited[y][x] = true;
                q.add(new int[]{y, x, r[2] - 1});
            }
        }
        return false;
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }

    static class Battery {
        int id;
        int y;
        int x;
        int range;
        int charge;

        public Battery(int id, int y, int x, int range, int charge) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.range = range;
            this.charge = charge;
        }
    }
}
