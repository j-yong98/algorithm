package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Marble{
    int y;
    int x;
    int v;
    int dir;
    int number;

    public Marble(int y, int x, int v, int dir,int number) {
        this.y = y;
        this.x = x;
        this.v = v;
        this.dir = dir;
        this.number = number;
    }
}
public class Problem47  {
    int n,m,t,k;
    int[] dy = {-1,0,0,1};
    int[] dx = {0,1,-1,0};
    List<Marble> arr;

    private int getDir(String dir){
        if (dir.equals("U")){
            return 0;
        }
        if (dir.equals("D")){
            return 3;
        }
        if (dir.equals("R")){
            return 1;
        }
        if (dir.equals("L")){
            return 2;
        }
        throw new IllegalArgumentException();
    }
    private boolean inRange(int y, int x){
        return y > 0 && y <= n && x > 0 && x <= n;
    }

    /**
     * 구슬의 현재 위치 + 속도가 아니라
     * 속도를 1씩 올리다 경계에 맞닿으면 방향을 바꿔주어야한다.
     */
    private void move(){
        for (Marble marble : arr) {
            int v = marble.v;
            while (v-- > 0) {
                int ny = marble.y + dy[marble.dir];
                int nx = marble.x + dx[marble.dir];
                if (!inRange(ny, nx)) {
                    marble.dir = 3 - marble.dir;
                    ny = marble.y + dy[marble.dir];
                    nx = marble.x + dx[marble.dir];
                }
                marble.y = ny;
                marble.x = nx;
            }
        }
    }
    private void collide(){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                List<Marble> tmp = new ArrayList<>();
                for (Marble marble : arr){
                    if (i == marble.y && j == marble.x){
                        tmp.add(marble);
                    }
                }
                if (tmp.size() <= k) continue;
                Collections.sort(tmp, new Comparator<Marble>() {
                    @Override
                    public int compare(Marble o1, Marble o2) {
                        if (o1.v == o2.v){
                            return o2.number - o1.number;
                        }
                        return o2.v - o1.v;
                    }
                });
                while (tmp.size() > k){
                    arr.remove(tmp.get(tmp.size()-1));
                    tmp.remove(tmp.get(tmp.size()-1));
                }
            }
        }
    }
    private void simulate(){
        move();
        collide();
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = getDir(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.add(new Marble(r,c,v,dir,i));
        }
        for (int i = 0; i < t; i++) {
            simulate();
        }
        System.out.println(arr.size());
        return arr.size();
    }
}
