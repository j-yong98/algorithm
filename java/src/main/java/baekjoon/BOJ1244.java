package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1244 {

    StringBuilder sb = new StringBuilder();
    int n;
    int students;
    int[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(line[i - 1]);
        students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (s[0] == 1)
                switchMul(s[1]);
            else
                switchSide(s[1]);
        }
        print(1);
        System.out.println(sb);
    }

    private void print(int l) {
        if (l > n) return;
        sb.append(arr[l]).append(" ");
        if (l % 20 == 0)
            sb.append("\n");
        print(l + 1);
    }

    private void switchMul(int num) {
        for (int i = num; i <= n; i += num)
            arr[i] ^= 1;
    }

    private void switchSide(int num) {
        int res = getMaxCnt(num - 1, num + 1);

        arr[num] ^= 1;
        for (int i = 1; i <= res; i++)
            arr[num + i] = arr[num - i] ^= 1;
    }

    private int getMaxCnt(int l, int r) {
        if (l <= 0 || r > n) return 0;

        int res = 0;
        if ((arr[l] ^ arr[r]) == 0) {
            res++;
            if (l - 1 > 0 && r + 1 <= n)
                res += getMaxCnt(l - 1, r + 1);
        }
        return res;
    }
}
