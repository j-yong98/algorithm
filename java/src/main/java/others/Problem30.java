package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30 {
    int n,k;
    int[] arr;
    private void combi(int l){
        if (l == k){
            for (int i = 0; i < k; i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++){
            arr[l] = i;
            combi(l+1);
        }
    }
    /**
     * 1~n 사이 수 k 개 선택
     * @throws IOException
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];

        combi(0);
    }
}
