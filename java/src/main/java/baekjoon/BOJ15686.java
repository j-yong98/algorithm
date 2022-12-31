package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    int n,m;
    int chickenCnt = 0;
    int ans = Integer.MAX_VALUE;
    List<int[]> town = new ArrayList<>();
    List<int[]> chicken = new ArrayList<>();

    List<int[]> selectedChicken = new ArrayList<>();

    private int getDistSum(){
        int sum = 0;
        for (int i = 0; i < town.size(); i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < selectedChicken.size(); j++){
                int dist = Math.abs(town.get(i)[0] - selectedChicken.get(j)[0]) + Math.abs(town.get(i)[1] - selectedChicken.get(j)[1]);
                min = Math.min(min,dist);
            }
            sum += min;
        }
        return sum;
    }
    private void f(int l){
        if (l == chickenCnt){
            if (selectedChicken.size() != m) return;

            ans = Math.min(ans,getDistSum());
            return;
        }
        selectedChicken.add(chicken.get(l));
        f(l+1);
        selectedChicken.remove(chicken.get(l));
        f(l+1);
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    town.add(new int[]{i,j});
                }
                else if (now == 2){
                    chicken.add(new int[]{i,j});
                    chickenCnt++;
                }
            }
        }
        f(0);
        System.out.println(ans);
        return ans;
    }
}
