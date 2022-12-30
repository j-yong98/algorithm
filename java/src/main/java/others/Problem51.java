package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem51 {
    int n;
    List<int[]> list;
    int[][] arr;

    int ans;
    private boolean overlapped(int[] a, int[] b){
        return (a[0] <= b[0] && b[1] <= a[1]) || (a[0] <= b[1] && b[1] <= a[1])
                || (b[0] <= a[0] && a[0] <= b[1]) || (b[0] <= a[1] && a[1] <= b[1]);
    }
    private boolean isPossible(){
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++){
                if (overlapped(list.get(i),list.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    private void f(int l){
        if (l == n) {
            if (isPossible()){
                ans = Math.max(ans,list.size());
            }
            return;
        }
        list.add(arr[l]);
        f(l+1);
        list.remove(arr[l]);
        f(l+1);
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        list = new ArrayList<>();
        ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
        }
        f(0);
        System.out.println(ans);
        return ans;
    }
}
