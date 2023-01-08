package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ8728 {
    int n;
    int max_apple = Integer.MIN_VALUE;
    int max_pear = Integer.MIN_VALUE;
    int min_apple = Integer.MAX_VALUE;
    int min_pear = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int now = Integer.parseInt(st.nextToken());
            if (now == 0){
                max_apple = Math.max(i, max_apple);
                min_apple = Math.min(i,min_apple);
            }
            else {
                max_pear = Math.max(max_apple,i);
                min_pear = Math.min(min_pear,i);
            }
        }
        System.out.println(Math.max(Math.abs(min_apple - max_pear),Math.abs(min_pear - max_apple)));
    }
}
