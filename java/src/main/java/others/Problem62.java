package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem62 {
    int n;
    int[] arr;
    List<Integer> team1 = new ArrayList<>();
    int sum;

    int ans = Integer.MAX_VALUE;
    private int getSum(List<Integer> t){
        int s = 0;
        for (Integer integer : t) {
            s += integer;
        }
        return s;
    }
    private void f(int l){
        if (l == 2 * n){
            if (team1.size() == n) {
                int t1 = getSum(team1);
                int t2 = sum - t1;
                ans = Math.min(ans, Math.abs(t1 - t2));
                }
            return;
        }
        f(l+1);
        team1.add(arr[l]);
        f(l+1);
        team1.remove(team1.size()-1);
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[2*n];
        st = new StringTokenizer(br.readLine());
        sum = 0;
        for (int i = 0; i < 2*n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        f(0);
        System.out.println(ans);
    }
}
