package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    int n, m;

    int[] arr;
    int[] check;
    private void print(){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private void perm(int d) {
        if (d == m) {
            print();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                arr[d] = i;
                perm(d + 1);
                check[i] = 0;
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        check = new int[n+1];

        perm(0);
    }
}
