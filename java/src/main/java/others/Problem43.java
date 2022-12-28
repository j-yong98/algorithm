package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem43 {
    int n, k;
    char[][] arr;

    int[] dy = {1,0,-1,0};
    int[] dx = {0,-1,0,1};

    private int getDir(char now, int dir){
        if (now == '/'){
            return dir ^ 1;
        }
        else {
            return 3 - dir;
        }
    }
    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private int move(int y, int x, int dir){
        int cnt = 0;
        while (inRange(y,x)) {
            System.out.println(y+" "+x+" "+dir);
            cnt++;
            dir = getDir(arr[y][x], dir);
            y += dy[dir];
            x += dx[dir];
        }
        return cnt;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++){
                arr[i][j] = s[j].charAt(0);
            }
        }
        k = Integer.parseInt(br.readLine());
        int ans = 0;
        int x = -1;
        int y = -1;
        int dir = -1;
        if (k <= n){
            y = 0;
            x = k - 1;
            dir = 0;
        }
        else if (k <= 2*n){
            y = k - n - 1;
            x = n - 1;
            dir = 1;
        }
        else if(k <= 3*n){
            y = n - 1;
            x = n - (k - 2 * n);
            dir = 2;
        }
        else {
            y = n - (k - 3 * n);
            x = 0;
            dir = 3;
        }
        ans = move(y,x,dir);
        System.out.println(ans);
    }
}
