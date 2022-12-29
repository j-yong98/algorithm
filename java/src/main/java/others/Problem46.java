package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Num {
    int y;
    int x;

    public Num(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Problem46 {
    int n, m;
    List<Integer>[][] arr;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }


    private Num nextPos(Num pos) {
        int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int max = 0;
        Num maxNum = null;
        for (int i = 0; i < 8; i++) {
            int yy = pos.y + dy[i];
            int xx = pos.x + dx[i];
            if (inRange(yy, xx)) {
                for (int j = 0; j < arr[yy][xx].size(); j++){
                    if (arr[yy][xx].get(j) > max){
                        max = arr[yy][xx].get(j);
                        maxNum = new Num(yy,xx);
                    }
                }
            }
        }
        return maxNum;
    }
    private Num getPos(int x){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < arr[i][j].size(); k++){
                    if (arr[i][j].get(k).equals(x)){
                        return new Num(i,j);
                    }
                }
            }
        }
        return null;
    }

    private void move(Num pos, Num nextPos, int number){
        int y = pos.y;
        int x = pos.x;

        int ny = nextPos.y;
        int nx = nextPos.x;

        boolean flag = false;
        for (int i = 0; i < (int) arr[y][x].size(); i++){
            if (arr[y][x].get(i).equals(number)){
                flag = true;
            }
            if (flag){
                arr[ny][nx].add(arr[y][x].get(i));
            }
        }

        while (arr[y][x].get(arr[y][x].size()- 1) != number){
            arr[y][x].remove(arr[y][x].get(arr[y][x].size()-1));
        }
        arr[y][x].remove(arr[y][x].get(arr[y][x].size() - 1));
    }

    private void simulate(int x) {
        Num pos = getPos(x);
        Num nextPos = nextPos(pos);
        if (nextPos != null) {
            move(pos, nextPos, x);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                arr[i][j].add(number);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            simulate(Integer.parseInt(st.nextToken()));
        }
        for (List<Integer>[] lists : arr) {
            for (List<Integer> list : lists) {
                if (list.size() == 0){
                    System.out.println("None");
                }
                else{
                    for (int i = list.size()-1; i >= 0; i--){
                        System.out.print(list.get(i)+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
