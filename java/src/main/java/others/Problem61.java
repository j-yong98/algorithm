package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem61 {
    int n;
    int r1,c1,r2,c2;
    int ans = Integer.MAX_VALUE;
    int[][] arr;
    List<int[]> location = new ArrayList<>();
    List<int[]> selectedLocation = new ArrayList<>();

    private int dist(int y1,int x1, int y2,int x2){
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
    private int calc(){
        int cnt = dist(r1,c1,selectedLocation.get(0)[0],selectedLocation.get(0)[1]);
        for (int i = 0; i < 2; i++){
            cnt += dist(selectedLocation.get(i)[0],selectedLocation.get(i)[1],selectedLocation.get(i+1)[0],selectedLocation.get(i+1)[1]);
        }
        cnt += dist(selectedLocation.get(2)[0],selectedLocation.get(2)[1],r2,c2);
        return cnt;
    }
    private void f(int cnt, int l){
        if (cnt == 3){
            ans = Math.min(ans,calc());
            return;
        }
        if (l == location.size()) return;

        f(cnt, l+1);
        selectedLocation.add(location.get(l));
        f(cnt + 1,l+1);
        selectedLocation.remove(selectedLocation.size()-1);
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++){
                arr[i][j] = s[j].charAt(0);
                if (arr[i][j] == 'S') {
                    r1 = i;
                    c1 = j;
                }
                else if (arr[i][j] == 'E'){
                    r2 = i;
                    c2 = j;
                }
            }
        }
        for (int k = 1; k < 10; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (arr[i][j] ==  k + '0'){
                        location.add(new int[]{i,j});
                    }
                }
            }
        }
        if (location.size() < 3) ans = -1;
        else f(0,0);
        System.out.println(ans);
        return ans;
    }
}
