package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16401 {
    int M, N;
    int[] arr;
    int ans = 0;

    /**
     * 과자 나눠주기
     * 이분 탐색 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        binarySearch(1, arr[N - 1]);
        System.out.println(ans);
    }

    private void binarySearch(int left, int right) {
        if (left > right) return;

        int mid = (left + right) / 2;
        if (canDiv(mid)) {
            ans = mid;
            binarySearch(mid + 1, right);
        } else
            binarySearch(left, mid - 1);
    }

    private boolean canDiv(int val) {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            cnt += arr[i] / val;
        if (cnt >= M) return true;
        return false;
    }
}
