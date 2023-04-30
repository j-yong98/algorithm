package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem141 {
    int n;
    int[] arr;
    /**
     * 단일 거래 최대화 하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int max = 0;
        int price = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < price)
                max = Math.max(max, price - arr[i]);
            else
                price = arr[i];
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
