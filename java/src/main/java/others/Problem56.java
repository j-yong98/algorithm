package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem56 {
    int n;
    int[] arr;
    boolean isFinish = false;
    private void print(int[] arr){
        for (int i : arr){
            System.out.print(i);
        }
    }
    private boolean isPossible(){
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n; j++){
                int num1 = 0;
                for (int k = j; k < j+i; k++) {
                    if (k >= n) break;
                    num1 *= 10;
                    num1 += arr[k];
                }
                int num2 = 0;
                for (int k = j + i; k < j + i + i; k++){
                    if (k >= n) break;
                    num2 *= 10;
                    num2 += arr[k];
                }
                if (num1 != 0 && num2 != 0 && num1 == num2) return false;
            }
        }
        return true;
    }
    private void f(int l){
        if (isFinish) return;
        if (l == n){
            if (isPossible()){
                print(arr);
                isFinish = true;
            }
            return;
        }
        for (int i = 4; i <= 6; i++){
            arr[l] = i;
            f(l+1);
        }
    }
    public void solution() throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        f(0);
    }
}
