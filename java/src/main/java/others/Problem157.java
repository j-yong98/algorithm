package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem157 {
    int n, m;
    int[] arr;
    /**
     * 숫자의 개수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write((upperBound(num) - lowerBound(num)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int lowerBound(int num) {
        int l = 0, r = n - 1;
        int min = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= num) {
                r = mid - 1;
                min = Math.min(min, mid);
            }
            else
                l = mid + 1;
        }
        return min;
    }

    private int upperBound(int num) {
        int l = 0, r = n - 1;
        int min = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > num) {
                r = mid - 1;
                min = Math.min(min, mid);
            }
            else
                l = mid + 1;
        }
        return min;
    }
}
