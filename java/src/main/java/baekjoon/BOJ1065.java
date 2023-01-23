package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1065 {
    int n;
    int cnt;
    public boolean is_hansoo(int num) {
        int a = num % 10;
        int b = (num / 10) % 10;
        int c = num / 100;
        if (a - b == b - c)
            return true;
        return false;
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n < 100)
            cnt = n;
        else {
            cnt = 99;
            for (int i = 100; i <= n; i++)
            {
                if (is_hansoo(i))
                    cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
