package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    int n;
    int[][] arr;
    int ans = 0;

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private boolean exist(int y, int x) {
        for (int i = 0; i < n; i++) {
            if (x == i) continue;
            if (arr[y][i] == 1) return true;
        }
        for (int i = 0; i < n; i++) {
            if (y == i) continue;
            if (arr[i][x] == 1) return true;
        }
        for (int i = 1; i < n; i++) {
            if (inRange(y+i,x+i) && arr[y + i][x + i] == 1) return true;
            if (inRange(y-i,x-i) && arr[y - i][x - i] == 1) return true;
        }
        for (int i = 1; i < n; i++){
            if (inRange(y-i,x+i) && arr[y-i][x+i] == 1) return true;
            if (inRange(y+i,x-i) && arr[y+i][x-i] == 1) return true;
        }
        return false;
    }

    private boolean isPossible(int y, int x) {
        if (exist(y,x)) return false;
        return true;
    }
    private void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void f(int l) {
        if (l == n) {
            ans += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isPossible(l,i)) {
                arr[l][i] = 1;
                f(l + 1);
                arr[l][i] = 0;
            }
        }
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        f(0);
        System.out.println(ans);
        return ans;
    }
}
