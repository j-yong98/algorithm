package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1417 {
    int n;
    int[] arr;
    /**
     * 국회의원 선거
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int ans = 0;
        while (true) {
            int idx = 0;
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (max < arr[i]) {
                    idx = i;
                    max = arr[i];
                }
            }
            if (max < arr[0])
                break;
            arr[idx]--;
            arr[0]++;
            ans++;
        }
        System.out.println(ans);
        br.close();
        return ans;
    }
}