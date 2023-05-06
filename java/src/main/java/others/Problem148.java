package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem148 {
    int T;
    /**
     * 트리의 재구성
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(br.readLine());
            int size = (int) Math.pow(2, k) - 1;
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int[] ans = new int[size + 1];
            tree(0, size - 1, 1, arr, ans);
            sb.append("#" + t + " ");
            for (int i = 0; i < k; i++) {
                for (int j = (int) Math.pow(2, i); j < (int)Math.pow(2, i + 1); j++)
                    sb.append(ans[j] + " ");
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void tree(int l, int r, int idx, int[] arr, int[] ans) {
        int mid = (l + r) / 2;
        ans[idx] = arr[mid];

        if (l == r) return;
        tree(l, mid - 1, idx * 2, arr, ans);
        tree(mid + 1, r, idx * 2 + 1, arr, ans);
    }
}
