package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    final int MAX = 1000000;
    int n;
    int[] d = new int[MAX + 1];
    private void init(){
        for (int i = 0; i <= n; i++){
            d[i] = MAX;
        }
        d[0] = 0;
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        init();
        d[1] = 0;
        d[2] = 1;
        d[3] = 1;
        for (int i = 4; i <= n; i++){
            if (i % 3 == 0){
                d[i] = Math.min(d[i],d[i / 3]+1);
            }
            if (i % 2 == 0){
                d[i] = Math.min(d[i],d[i / 2]+1);
            }
            d[i] = Math.min(d[i], d[i - 1]+1);
        }
        System.out.println(d[n]);
        return d[n];
    }
}
