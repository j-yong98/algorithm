package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3040 {
    final int SIZE = 9;
    int[] arr = new int[SIZE];
    int[] copy = new int[SIZE];
    int sum = 0;

    /**
     * 백설 공주와 일곱 난쟁이
     * 9명 중 2명을 빼는 방식으로 투포인터 사용
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++)
            sum += copy[i] = arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int l = 0;
        int r = SIZE - 1;
        while (l < r) {
            int tmp = sum - (arr[l] + arr[r]);
            if (tmp == 100)
                break;
            if (tmp < 100)
                r--;
            else
                l++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (arr[l] == copy[i] || arr[r] == copy[i]) continue;
            sb.append(copy[i]).append("\n");
        }
        System.out.print(sb);
    }
}
