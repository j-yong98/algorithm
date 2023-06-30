package baekjoon;

import java.io.*;

public class BOJ1722 {
    int n;
    long[] fac;
    boolean[] visited;
    StringBuilder sb = new StringBuilder();

    /**
     * 순열의 순서
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        fac = new long[n + 1];
        visited = new boolean[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i;
        String[] line = br.readLine().split(" ");
        if (Integer.parseInt(line[0]) == 1) {
            long k = Integer.parseInt(line[1]);
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) continue;
                    if (k > fac[n - i - 1])
                        k -= fac[n - i - 1];
                    else {
                        visited[j] = true;
                        sb.append(j).append(" ");
                        break;
                    }
                }
            }
        }
        else {
            int[] tmp = new int[n];
            long k = 1;
            for (int i = 0; i < n; i++)
                tmp[i] = Integer.parseInt(line[i + 1]);
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < tmp[i]; j++) {
                    if (visited[j]) continue;
                    k += fac[n - i - 1];
                }
                visited[tmp[i]] = true;
            }
            sb.append(k);
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    /**
     * k 번째 수열을 구한다면 k로 만들 수 있는 경우의 수를 빼주면서 구해준다.
     * 만약 n이 4이고 k가 3이라면 맨 앞자리가 1인 경우 경우는 3!이다. k는 0~3!번째 안에 속하는 것을 알기 때문에 맨 앞자리가 1인 것을 알 수 있다.
     * 이렇게 경우를 줄여 나가면 된다.
     */
}
