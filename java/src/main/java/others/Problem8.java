package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem8 {
    int n,t;
    int[] arr1;
    int[] arr2;
    int[] arr3;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr1 = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr3[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++){
            int tmp1 = arr1[n-1];
            int tmp2 = arr2[n-1];
            int tmp3 = arr3[n-1];
            for (int j = n-1; j >= 1; j--){
                arr1[j] = arr1[j-1];
            }
            arr1[0] = tmp3;
            for (int j = n-1; j >= 1; j--){
                arr2[j] = arr2[j-1];
            }
            arr2[0] = tmp1;
            for (int j = n-1; j >= 1; j--){
                arr3[j] = arr3[j-1];
            }
            arr3[0] = tmp2;
        }
        for (int i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : arr3) {
            System.out.print(i+" ");
        }
    }
}
