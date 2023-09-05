package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6236 {
    final int MAX = 1_000_000_000;
    int M, N;
    int[] arr;
    int ans = 0;

    /**
     * 용돈 관리
     * 이분 탐색 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        ans = Arrays.stream(arr).sum();
        binarySearch(0, MAX);
        System.out.println(ans);
    }

    private void binarySearch(int left, int right) {
        if (left > right) return;

        int mid = (left + right) / 2;
        if (canDiv(mid)) {
            ans = mid;
            binarySearch(left, mid - 1);
        } else
            binarySearch(mid + 1, right);
    }

    private boolean canDiv(int val) {
        int tmp = val;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (val < arr[i]) return false;
            if (tmp < arr[i]) {
                tmp = val;
                cnt++;
            }
            tmp -= arr[i];
        }
        return cnt <= M;
    }
}
