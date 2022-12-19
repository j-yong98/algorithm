import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topologicalSort {

    public static void main(String[] args) {
        int[][] arr = {
                {3,8},
                {3,2},
                {5,2},
                {5,9},
                {4,6},
                {2,8},
                {2,1},
                {2,9},
                {1,8},
                {8,9},
                {9,7},
        };
        List<List<Integer>> t = new ArrayList<>();
        int[] cnt = new int[10];
        for (int i = 0; i < 10; i++){
            t.add(new ArrayList<>());
        }
        for (int i = 0; i < 11; i++){
            t.get(arr[i][0]).add(arr[i][1]);
            cnt[arr[i][1]] += 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 10; i++){
            if (cnt[i] == 0){
                q.add(i);
                cnt[i] = -1;
            }
        }
        while(!q.isEmpty()){
            Integer n = q.poll();
            System.out.print(n+"-");
            List<Integer> integers = t.get(n);
            for (Integer integer : integers) {
                cnt[integer]--;
                if (cnt[integer] == 0){
                    q.add(integer);
                    cnt[integer] = -1;
                }
            }
        }
    }
}
