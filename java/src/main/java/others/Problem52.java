package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem52 {
    int n,m;
    List<int[]> list;
    List<int[]> horizontal;
    List<Integer> ans;

    List<Integer> ladder;

    int min = Integer.MAX_VALUE;

    int lastFloor = 0;


    private int fallDown(List<int[]> lines, int start){
        int now = start;
        int floor = 0;
        for (int i = 0; i < lastFloor; i++) {
            floor++;
            for (int[] ints : lines) {
                if ((ints[0] == now || ints[0] + 1 == now) && floor == ints[1]) {
                    now = ints[0] == now ? ints[0] + 1 : ints[0];
                    break;
                }
            }
        }
        return now;
    }
    private void init(List<Integer> make){
        while (!make.isEmpty()){
            make.remove(0);
        }
    }
    private void makeAns(List<Integer> make,List<int[]> lines){
        init(make);
        for (int i = 1; i <= n; i++){
            int end = fallDown(lines,i);
            make.add(end);
        }
    }
    private boolean isEqual(List<Integer> ans, List<Integer> ladder){
        for (int i = 0; i < n; i++){
            if (!ans.get(i).equals(ladder.get(i))){
                return false;
            }
        }
        return true;
    }
    private void f(int l){
        if(l == m) {
            makeAns(ladder, horizontal);
            if (isEqual(ans, ladder)) {
                min = Math.min(min, horizontal.size());
            }
            return;
        }
        horizontal.add(list.get(l));
        f(l+1);
        horizontal.remove(list.get(l));
        f(l+1);
    }
    private void getLastFloor(){
        for (int[] ints : list) {
            if (ints[1] > lastFloor){
                lastFloor = ints[1];
            }
        }
    }

    /**
     * n 개의 가로줄과 m개의 세로줄이 있을 때 m개의 세로줄 중 k개를 선택했을 때 최소 k
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        ladder = new ArrayList<>();
        ans = new ArrayList<>();
        horizontal = new ArrayList<>();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }
        getLastFloor();
        makeAns(ans,list);
        f(0);
        System.out.println(min);
        return min;
    }
}
