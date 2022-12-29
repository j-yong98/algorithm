package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem50 {
    int k, n;
    int[] arr;
    private boolean isPossible(){
        int cnt = 1;
        for (int i = 0; i < n - 1; i++){
            if (arr[i] == arr[i+1]) cnt++;
            else {
                if (cnt > 2) return false;
                cnt = 1;
            }
        }
        if (cnt > 2) return false;
        return true;
    }
    private void f(int l){
        if (l == n) {
            if(isPossible()) {
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 1; i <= k; i++){
            arr[l] = i;
            f(l+1);
        }
    }

    /**
     * 1~k까지 숫자 중 n 개를 뽑아 출력한다. 같은 숫자가 연속으로 3번 이상 반복 되면 출력하면 안된다.
     * @throws IOException
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        f(0);
    }
}
