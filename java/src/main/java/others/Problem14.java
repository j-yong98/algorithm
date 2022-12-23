package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14 {
    int n;
    int[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[] tmp = new int[n];
            int idx = 0;
            for (int j = 0; j < n; j++){
                if (j+1 >= s && j+1<= e) continue;
                tmp[idx++] = arr[j];
            }

            for (int j = 0; j < n; j++){
                arr[j] = tmp[j];
            }
        }
        System.out.println(Arrays.stream(arr).filter(i -> i != 0).count());
        for (int i : arr) {
            if (i == 0) continue;
            System.out.println(i);
        }
    }
}
