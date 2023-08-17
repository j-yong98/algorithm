package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546 {
    final int SIZE = 14;
    int N;
    int a, b;
    int aStock;
    int bStock;
    int[] arr = new int[SIZE];

    /**
     * 기적의 매매법
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < SIZE; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        a = N;
        b = N;
        A();
        B();
        a += arr[SIZE - 1] * aStock;
        b += arr[SIZE - 1] * bStock;
        if (a > b)
            System.out.println("BNP");
        else if (a < b)
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");
    }

    private void A() {
        for (int i = 0; i < SIZE; i++) {
            int buy = a / arr[i];
            a -= buy * arr[i];
            aStock += buy;
        }
    }

    private void B() {
        for (int i = 3; i < SIZE; i++) {
            if (arr[i - 3] < arr[i - 2] && arr[i - 2] < arr[i - 1] && arr[i - 1] < arr[i]) {
                b += bStock * arr[i];
                bStock = 0;
            } else if (arr[i - 3] > arr[i - 2] && arr[i - 2] > arr[i - 1] && arr[i - 1] > arr[i]) {
                int buy = b / arr[i];
                b -= buy * arr[i];
                bStock += buy;
            }
        }
    }
}
