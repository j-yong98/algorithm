package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem76 {
    int n;
    int[][] arr;
    int[][] d;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    List<int[]> list = new ArrayList<>();

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private void print() {
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                list.add(new int[]{i,j});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = 1;
            }
        }
        /**
         * 정렬을 하지 않으면
         * 1 2 3
         * 6 5 4
         * 7 8 9
         * 의 경우를 생각해보면 된다
         * 해당 경우를 0,0 ~ n-1,n-1 순으로 진행 한다 하면
         * dp의 값이
         * 1 2 3
         * 4 3 4
         * 5 4 5 가 되어버린다.
         */
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return arr[o1[0]][o1[1]] - arr[o2[0]][o2[1]];
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i);
            for (int k = 0; k < 4; k++) {
                int y = pos[0] + dy[k];
                int x = pos[1] + dx[k];
                if (inRange(y, x) && arr[y][x] > arr[pos[0]][pos[1]]) {
                    d[y][x] = Math.max(d[y][x], d[pos[0]][pos[1]] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt());
        return Arrays.stream(d).flatMapToInt(Arrays::stream).max().getAsInt();
    }
}
