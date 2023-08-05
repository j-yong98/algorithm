package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14595 {
    int N;
    int M;

    /**
     * 동방 프로젝트
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = i;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < M; i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int mark = arr[x];
            for (int j = x; j <= y; j++)
                arr[j] = mark;
        }
        int cnt = 1;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == arr[i - 1]) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
