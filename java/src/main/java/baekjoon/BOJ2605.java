package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2605 {
    int n;
    int[] arr;
    LinkedList<Integer> ll = new LinkedList<>();
    //문제 이름
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            ll.add(i - arr[i], i + 1);
        for (Integer integer : ll)
            System.out.print(integer + " ");
    }
}
