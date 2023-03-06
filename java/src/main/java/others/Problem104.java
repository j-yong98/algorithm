package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem104 {
    int n, k;
    int[][] arr;
    int[] check;
    List<HashSet<Integer>> listSet = new ArrayList<>();
    //문제 이름
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            listSet.add(new HashSet<>());
            listSet.get(i).add(i);
            check[i] = i;
        }
        arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < k; j++) {
                int first = arr[j][0];
                int second = arr[j][1];
                int tmp = check[first];
                check[first] = check[second];
                check[second] = tmp;
                if (!listSet.get(check[first]).contains(first))
                    listSet.get(check[first]).add(first);
                if (!listSet.get(check[second]).contains(second))
                    listSet.get(check[second]).add(second);
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.println(listSet.get(i).size());
    }
}
