package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    int n;
    int[] arr;
    int[] d;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        d = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            d[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
        return Arrays.stream(d).max().getAsInt();
    }
}
