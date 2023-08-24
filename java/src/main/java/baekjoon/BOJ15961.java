package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 {
    int N;
    int d;
    int k;
    int c;
    int[] dishes;
    int[] count;

    /**
     * 회전 초밥
     * 슬라이싱 윈도우
     * K만큼 구간을 처음 산정 후 그 구간만큼 움직이며 최대 가지수 선정
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dishes = new int[N + k];
        count = new int[d + 1];
        for (int i = 0; i < N; i++)
            dishes[i] = Integer.parseInt(br.readLine());
        for (int i = N; i < N + k; i++)
            dishes[i] = dishes[i - N];
        count[c] = 1;
        int tmp = 1;
        for (int i = 0; i < k; i++) {
            count[dishes[i]]++;
            if (count[dishes[i]] == 1)
                tmp += 1;
        }
        int max = tmp;
        for (int i = 1; i < N; i++) {
            count[dishes[i - 1]]--;
            if (count[dishes[i - 1]] == 0)
                tmp--;
            count[dishes[i + k - 1]]++;
            if (count[dishes[i + k - 1]] == 1)
                tmp++;
            max = Math.max(max, tmp);
        }
        System.out.println(max);
        br.close();
    }
}
