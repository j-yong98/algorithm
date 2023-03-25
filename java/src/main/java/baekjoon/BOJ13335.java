package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13335 {
    int n, w, l;
    int[] arr;
    int[] onBridge;
    int next = 0;
    int weigth = 0;
    int time = 0;
    private void move() {
        for (int i = 0; i < next; i++) {
            if (onBridge[i] == -1)
                continue;
            onBridge[i]++;
            if (onBridge[i] > w) {
                weigth -= arr[i];
                onBridge[i] = -1;
            }
        }
    }
    /**
     * 트럭
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n];
        onBridge = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        while (onBridge[n - 1] != -1) {
            time++;
            move();
            if (next < n && weigth + arr[next] <= l) {
                weigth += arr[next];
                onBridge[next]++;
                next++;
            }
        }
        System.out.println(time);
    }
}
