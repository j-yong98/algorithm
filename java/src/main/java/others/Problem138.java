package others;

import java.io.*;
import java.util.*;

public class Problem138 {
    int n;
    Integer[] arr;
    Deque<String> list = new ArrayDeque<>();
    String ans = "";
    /**
     * 최대 숫자 만들기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = Integer.toString(o1) + Integer.toString(o2);
                String b = Integer.toString(o2) + Integer.toString(o1);
                return b.compareTo(a);
            }
        });
        for (int i = 0; i < n; i++)
            ans += String.valueOf(arr[i]);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
