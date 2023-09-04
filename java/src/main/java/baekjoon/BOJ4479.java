package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4479 {
    int N;
    char[] arr;

    /**
     * 칸토어 집합
     * 분할 정복 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            N = Integer.parseInt(line);
            int size = (int) Math.pow(3, N);
            arr = new char[size];
            for (int i = 0; i < size; i++)
                arr[i] = '-';
            recursion(size, 0, size);
            for (int i = 0; i < size; i++)
                sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void recursion(int size, int y, int x) {
        if (size == 0)
            return;
        int next = size / 3;

        for (int i = y + next; i < y + next + next; i++)
            arr[i] = ' ';

        recursion(next, y, y + next);
        recursion(next, y + next + next, x);
    }
}
