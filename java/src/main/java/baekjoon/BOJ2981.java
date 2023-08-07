package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ2981 {
    int N;
    int[] arr;

    /**
     * 검문
     * 정수론 문제
     * a1 = o1*m + b
     * a2 = o2*m + b
     * a3 = o3*m + b
     * ...
     * (o2 - o1)m
     * (o3 - o2)m
     * ...
     * 이 차이들의 최대 공약수를 구해주고 최대 공약수의 약수를 구해주면 되는 문제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int g = arr[1] - arr[0];
        for (int i = 2; i < N; i++)
            g = gcd(g, arr[i] - arr[i - 1]);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                ans.add(i);
                if (i != g / i) ans.add(g / i);
            }
        }
        Collections.sort(ans);
        ans.remove(0);
        StringBuilder sb = new StringBuilder();
        ans.stream().forEach(e -> sb.append(e).append(" "));
        System.out.println(sb);
        br.close();
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
