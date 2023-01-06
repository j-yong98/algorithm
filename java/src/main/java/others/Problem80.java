package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem80 {
    int n;
    int[] arr;
    int[] d;

    /**
     * 최대 점프 횟수
     * n개의 최대 점프 가능 거리가 주어졌을 때 첫 번째 위치로부터 최대 몇 번의 점프할 수 있는가?
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        d = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (arr[j] + j >= i)
                    d[i] = Math.max(d[i],d[j]+1);
            }
            if (d[i] == 0) break;
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
        return Arrays.stream(d).max().getAsInt();
    }
}
