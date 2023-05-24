package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem158 {
    int n, m;
    int[] arr;
    /**
     * 가장 먼저 나오는 숫자
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int res = binarySearch(num);
            if (!(res <= n && arr[res] == num))
                res = -1;
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int binarySearch(int num) {
        int l = 1, r = n;
        int min = n + 1;
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
}
