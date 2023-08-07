package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535 {
    int N;
    int[] health;
    int[] happy;
    int ans;
    /**
     * 안녕
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        health = new int[N];
        happy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            health[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            happy[i] = Integer.parseInt(st.nextToken());
        getMaxHappy(0, 0, 100);
        System.out.println(ans);
        br.close();
    }

    private void getMaxHappy(int n, int h, int hp) {
        if (n == N) {
            if (hp > 0)
                ans = Math.max(ans, h);
            return;
        }
        getMaxHappy(n + 1, h + happy[n], hp - health[n]);
        getMaxHappy(n + 1, h, hp);
    }
}
