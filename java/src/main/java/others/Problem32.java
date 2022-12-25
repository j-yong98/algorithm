package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Dice {
    int up;
    int front;
    int right;
    public Dice() {
        up = 1;
        front = 2;
        right = 3;
    }
}

public class Problem32 {
    int n, m, r, c;
    int[][] arr;

    Dice dice;
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};

    private int getDir(String dir) {
        if (dir.equals("R")) return 0;
        if (dir.equals("L")) return 1;
        if (dir.equals("D")) return 2;
        if (dir.equals("U")) return 3;
        throw new IllegalArgumentException();
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void print(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void simulate(int dir) {
        if (!inRange(r+dy[dir], c + dx[dir])) return;
        if (dir == 0) {// 0 1
            int tmp = dice.up;
            dice.up = 7 - dice.right;
            dice.right = tmp;
        } else if (dir == 1) {// 0 -1
            int tmp = dice.up;
            dice.up = dice.right;
            dice.right = 7 - tmp;
        } else if (dir == 2) {// 1 0
            int tmp = dice.front;
            dice.front = dice.up;
            dice.up = 7 - tmp;
        } else {//-1 0
            int tmp = dice.up;
            dice.up = dice.front;
            dice.front = 7 - tmp;
        }
        r += dy[dir];
        c += dx[dir];
        arr[r][c] = 7 - dice.up;
    }

    /**
     * r,c 위치에서 시작해 주사위를 m번 L,R,U,D 중 한 곳으로 굴렸을 때 주사위의 아래 부분이 해당 좌표에 남는데 다 굴렸을 때 좌표의 합
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[n][n];
        dice = new Dice();
        arr[r][c] = 7 - dice.up;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int dir = getDir(st.nextToken());
            simulate(dir);
            print();
        }
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += Arrays.stream(arr[i]).filter(s -> s != 0).sum();
        }
        System.out.println(sum);
        return sum;
    }
}
