package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2792 {
    int N, M;
    int[] arr;
    int ans;

    /**
     *  보석 상자
     *  이분 탐색 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        binarySearch(1, arr[M - 1]);
        System.out.println(ans);
    }

    private void binarySearch(int left, int right) {
        if (left > right) return;

        int mid = (left + right) >> 1;
        if (getPart(mid)) {
            ans = mid;
            binarySearch(left, mid - 1);
        } else
            binarySearch(mid + 1, right);
    }

    private boolean getPart(int val) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (arr[i] % val == 0)
                cnt += arr[i] / val;
            else
                cnt += arr[i] / val + 1;
        }
        if (cnt > N) return false;
        return true;
    }
}
