package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5 {
    int n,t;
    int[] arr;
    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n*2];
        st = new StringTokenizer(br.readLine());
        int i;
        for (i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++){
            arr[i+j] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < t; j++){
            int tmp = arr[n*2-1];
            for (int k = n*2-1; k >= 1; k--){
                arr[k] = arr[k-1];
            }
            arr[0] = tmp;
        }
        for (i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int j = 0; j < n; j++){
            System.out.print(arr[j+i]+" ");
        }
        return arr;
    }
}
