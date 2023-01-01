package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem56 {
    int n;
    List<Integer> list = new ArrayList<>();
    boolean isFinish = false;
    private void print(List<Integer> list){
        for (int i : list) {
            System.out.print(i);
        }
    }
    private boolean isEqual(int s1, int e1, int s2, int e2){
        for (int i = 0; i <= e1 - s1; i++){
            if (list.get(s1 + i) != list.get(s2 + i)) return false;
        }
        return true;
    }
    private boolean isPossible(){
        int len = 1;
        while (true){
            int end1 = list.size()-1;
            int start1 = end1 - len + 1;
            int end2 = start1 - 1;
            int start2 = end2 - len + 1;

            if (start2 < 0) break;

            if (isEqual(start1,end1, start2,end2)) return false;
            len++;
        }
        return true;
    }
    private void f(int l){
        if (isFinish) return;
        if (l == n){
            print(list);
            isFinish = true;
            return;
        }
        for (int i = 4; i <= 6; i++){
            list.add(i);
            if (isPossible()) {
                f(l + 1);
            }
            list.remove(list.size()-1);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f(0);
    }
}
