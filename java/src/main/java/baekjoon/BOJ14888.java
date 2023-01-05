package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14888 {

    final int OP_CASE = 4;

    final int[] op = new int[OP_CASE];
    int n;
    int[] arr;

    List<Integer> selectedOp = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    private int calc(){
        int res = arr[0];
        for (int i = 0; i < n - 1; i++){
            int num = arr[i+1];
            int op = selectedOp.get(i);
            if (op == 0){
                res += num;
            }
            else if(op == 1){
                res -= num;
            }
            else if(op == 2){
                res *= num;
            }
            else {
                res /= num;
            }
        }
        return res;
    }
    private void f(int l){
        if (l == n) {
            int res = calc();
            min = Math.min(min,res);
            max = Math.max(max,res);
            return;
        }
        for (int i = 0; i < OP_CASE; i++){
            if (op[i] == 0) continue;
            op[i] -= 1;
            selectedOp.add(i);
            f(l+1);
            selectedOp.remove(selectedOp.size()-1);
            op[i] += 1;
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OP_CASE; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        f(1);
        System.out.println(max);
        System.out.println(min);
    }
}
