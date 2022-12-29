package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Marble2{
    int y;
    int x;
    int w;
    int dir;
    int number;

    public Marble2(int y, int x, int w, int dir, int number) {
        this.y = y;
        this.x = x;
        this.w = w;
        this.dir = dir;
        this.number = number;
    }
}
public class Problem48 {
    int T;
    int n;

    List<Marble2> list;

    int[] dy = {-1,0,0,1};
    int[] dx = {0,-1,1,0};
    private int getDir(String dir){
        if (dir.equals("U")) return 0;
        if (dir.equals("L")) return 1;
        if (dir.equals("R")) return 2;
        if (dir.equals("D")) return 3;
        throw new IllegalArgumentException();
    }
    private boolean move(){
        boolean flag = false;
        List<Marble2> tmp = new ArrayList<>();
        for (Marble2 marble : list) {
            marble.y = marble.y + dy[marble.dir];
            marble.x = marble.x + dx[marble.dir];
            tmp = Stream.concat(tmp.stream(), collide(marble).stream()).collect(Collectors.toList());
            if (tmp.size() > 0){
                flag = true;
            }
        }
        list.removeAll(tmp);
        return flag;
    }
    private List<Marble2> collide(Marble2 marble2){
        boolean flag = false;
        Set<Marble2> tmp = new HashSet<>();
        for (Marble2 marble : list) {
            if (marble2 == marble) continue;
            if (marble2.y == marble.y && marble2.x == marble.x){
                if (marble2.w > marble.w){
                    tmp.add(marble);
                }
                else if (marble2.w == marble.w){
                    tmp.add(marble2.number > marble.number ? marble : marble2);
                }
                else {
                    tmp.add(marble2);
                }
            }
        }
        return tmp.stream().collect(Collectors.toList());
    }
    private int simulate(){
        int time = -1;
        for (int i = 1; i <= 4000; i++){
            if (move()) time = i;
        }
        return time;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) * 2;
                int x = Integer.parseInt(st.nextToken()) * 2;
                int w = Integer.parseInt(st.nextToken());
                int dir = getDir(st.nextToken());
                list.add(new Marble2(y, x, w, dir, i));
            }
            System.out.println(simulate());
        }
    }
}
