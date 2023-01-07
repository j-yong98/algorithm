package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem86 {
    final int MAX_N = 100;
    final int MAX_M = 10000;
    final int MAX_ANS = 10001;
    int n, m;
    int[] arr = new int[MAX_N];
    int[] d = new int[MAX_M + 1];

    private void init() {
        for (int i = 0; i < MAX_M; i++) {
            d[i] = MAX_ANS;
        }
        d[0] = 0;
    }
    private void print(){
        for (int i = 1; i <= m; i++){
            System.out.print(d[i] == MAX_ANS ? -1 +" ": d[i] + " ");
        }
        System.out.println();
    }

    /**
     * 중복없이 부분 수열의 합 m
     * 뒤에서부터 시작하면 중복을 제거할 수 있다.
     */
    public int solution() throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            for (int j = m; j >= 0; j--){
                if (j < arr[i] || d[j-arr[i]] == MAX_ANS) continue;
                d[j] = Math.min(d[j], d[j-arr[i]] + 1);
            }
            print();
        }
        System.out.println(d[m] == MAX_ANS ? -1 : d[m]);
        return d[m] == MAX_ANS ? -1 : d[m];
    }
}
