package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ10815 {
    int n, m;
    Set<Integer> set = new HashSet<>();
    //숫자 카드
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            set.add(Integer.valueOf(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            System.out.print(set.contains(num) ? 1  + " " : 0 + " ");
        }
    }
}
