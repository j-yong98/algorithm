import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17 {
    private final int N = 4;
    int[][] arr = new int[N][N];

    /**
     * 배열을 90도 회전
     */
    private void rotate(){
        int[][] tmp = new int[N][N];
        for (int i = 0;i < N; i++){
            for (int j = 0; j < N; j++){
                tmp[i][j] = arr[N-j-1][i];
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }

    /**
     * 아래로 떨어지는 구간
     */
    private void fallDown() {
        for (int i = 0; i < N; i++){
            int[] tmp = new int[N];
            int idx = N-1;
            for (int j = N - 1; j >= 0; j--){
                if (arr[j][i] == 0) continue;
                tmp[idx--] = arr[j][i];
            }
            for (int j = 0; j < N; j++){
                arr[j][i] = tmp[j];
            }
        }
    }

    /**
     * 방향 숫자 전환
     */
    private int getDir(String dir) {
        if (dir.equals("D")) return 0;
        if (dir.equals("R")) return 1;
        if (dir.equals("U")) return 2;
        if (dir.equals("L")) return 3;
        throw new IllegalArgumentException();
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    /**
     * 아래부터 위에랑 같은 숫자가 있는지 판단
     * 있다면 합쳐주기
     */
    private void calc() {
        int dy = -1;
        int dx = 0;
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (arr[j][i] == 0) continue;
                int y = i + dx;
                int x = j + dy;
                if (!inRange(y, x)) {
                    tmp[j][i] = arr[j][i];
                    continue;
                }
                if (arr[j][i] == arr[x][y]) {
                    tmp[x][y] = arr[j][i] + arr[x][y];
                    arr[x][y] = 0;
                    arr[j][i] = 0;
                } else {
                    tmp[j][i] = arr[j][i];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }

    }

    void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = getDir(br.readLine());
        for (int i = 0; i < dir; i++){
            rotate();
        }
        fallDown();
        calc();
        fallDown();
        for (int i = 0; i < 4 - dir; i++){
            rotate();
        }
        print(arr);
    }
}
