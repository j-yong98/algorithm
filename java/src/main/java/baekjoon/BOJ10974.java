package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10974 {
    int N;
    int[] arr;

    /**
     * 모든 순열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;

        do {
            Arrays.stream(arr).forEach(a -> sb.append(a + 1).append(" "));
            sb.append("\n");
        } while(np());
        System.out.println(sb);
    }

    private boolean np() {
        int i = N - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (arr[i - 1] >= arr[j]) j--;
        swap(i - 1, j);

        int k = N - 1;
        while (i < k) swap(i++, k--);
        return true;
    }

    private void swap(int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}
