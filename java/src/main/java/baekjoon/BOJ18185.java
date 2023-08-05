package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18185 {

    int N;
    int[] arr;

    /**
     * 라면 사기
     * 현재를 idx라고 한다면
     * idx + 1과 idx + 2의 상태를 봐야 한다.
     * 만약 idx + 1이 idx + 2보다 크다면 둘의 차와 idx의 값을 비교하여 최솟값으로 우선 idx + 1의 값을 구해준뒤 3개를 한번에 구매한다.
     * 만약에 idx + 1 <= idx + 2라면
     * 7개를 살 수 있는 만큼 사고 5개를 살고 있는 만큼 사면 된다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                int cost = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                ans += cost * 5;
                arr[i] -= cost;
                arr[i + 1] -= cost;

                cost = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cost * 7;
                arr[i] -= cost;
                arr[i + 1] -= cost;
                arr[i + 2] -= cost;
            } else {
                int cost = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cost * 7;
                arr[i] -= cost;
                arr[i + 1] -= cost;
                arr[i + 2] -= cost;

                cost = Math.min(arr[i], arr[i + 1]);
                ans += cost * 5;
                arr[i] -= cost;
                arr[i + 1] -= cost;
            }
            ans += arr[i] * 3;
        }
        System.out.println(ans);
    }
}
