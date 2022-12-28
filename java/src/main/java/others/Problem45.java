package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Bead{
    private int y;
    private int x;
    private int dir;

    public Bead(int y, int x,String dir) {
        this.y = y;
        this.x = x;
        setDir(dir);
    }

    private void setDir(String dir){
        if (dir.equals("U")){
            this.dir = 0;
        }
        else if(dir.equals("D")){
            this.dir = 3;
        }
        else if (dir.equals("L")){
            this.dir = 2;
        }
        else {
            this.dir = 1;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "pos: " + y + " " + x + " dir :" + dir;
    }
}
public class Problem45 {
    int T;
    int n,m;
    int[] dy = {-1,0,0,1};
    int[] dx = {0,1,-1,0};
    List<Bead> beads;

    private boolean inRange(int y, int x){
        return y > 0 && y <= n && x > 0 && x <= n;
    }
    private void move(){
        for (Bead bead : beads) {
            int cy = bead.getY() + dy[bead.getDir()];
            int cx = bead.getX() + dx[bead.getDir()];
            if (inRange(cy,cx)){
                bead.setY(cy);
                bead.setX(cx);
            }
            else {
                bead.setDir(3 - bead.getDir());
            }
        }
    }
    private void collide(){
        List<Bead> tmp = new ArrayList<>();
        int[][] arr = new int[n+1][n+1];
        for (Bead bead : beads) {
            arr[bead.getY()][bead.getX()] += 1;
        }
        for (Bead bead : beads) {
            if (arr[bead.getY()][bead.getX()] < 2){
                tmp.add(bead);
            }
        }
        beads = tmp;
    }
    private void simulate(){
        move();
        collide();
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            beads = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                Bead bead = new Bead(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
                beads.add(bead);
            }
            for (int i = 0; i < 2 * n; i++) {
                simulate();
            }
            System.out.println(beads.size());
        }
    }
}
