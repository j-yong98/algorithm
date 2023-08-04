package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15787 {
    int N, M;
    int[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());
            int x;
            switch (cmd) {
                case 1:
                    x = Integer.parseInt(st.nextToken());
                    arr[train] = (arr[train] & (1 << x)) == 0 ? (arr[train] | (1 << x)) : arr[train];
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    arr[train] = (arr[train] & (1 << x)) == 0 ? arr[train] : (arr[train] & ~(1 << x));
                    break;
                case 3:
                    arr[train] <<= 1;
                    arr[train] = (arr[train] & (1 << 21)) != 0 ? arr[train] ^ (1 << 21) : arr[train];
                    break;
                case 4:
                    arr[train] >>= 1;
                    arr[train] = (arr[train] & 1) == 1 ? arr[train] ^ 1 : arr[train];
                    break;
            }
        }
        Set<Integer> canGo = new HashSet<>();
        for (int i = 1; i <= N; i++)
            canGo.add(arr[i]);
        System.out.println(canGo.size());
    }
}
