package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    int n,m;
    int[] arr;

    private void print(){
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
    private void comb(int d, int s){
        if (d == m) {
            print();
            return;
        }
        for (int i = s; i <= n; i++){
            arr[d] = i;
            comb(d+1, i+1);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        comb(0,1);
    }
}
