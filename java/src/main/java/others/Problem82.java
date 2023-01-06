package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem82 {
    final int MAX = 1000;
    int n;
    List<int[]> list = new ArrayList<>();
    int[] d = new int[MAX + 1];

    /**
     * 선분 겹치지 않게 고르기
     * 우선 a를 기준으로 정렬해준다.
     * i번째의 a가 j (0 <= j < i)의 b보다 작지 않으면 겹치지 않으니 d[i] = d[j] + 1
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++){
            d[i] = 1;
            for (int j = 0; j < i; j++){
                int x2j = list.get(j)[1];
                int x1i = list.get(i)[0];
                if (x2j < x1i){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
