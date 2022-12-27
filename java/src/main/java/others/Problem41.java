package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem41 {
    private final int MAX = 1000000;
    int n;
    final int[] arr = new int[MAX * 2 + 1];

    private boolean possible(int num, int op){
        if (op == 2){
            return num % 2 == 0;
        }
        if (op == 3){
            return num % 3 == 0;
        }
        return true;
    }
    private int calc(int number, int op){
        if (op == 0){
            return number - 1;
        }
        if (op == 1){
            return number + 1;
        }
        if (op == 2){
            return number / 2;
        }
        if (op == 3){
            return number / 3;
        }
        throw new IllegalArgumentException();
    }
    private boolean inRange(int num){
        return n >= 1 && n <= 2 * n - 1;
    }

    /**
     * n에서 1로 되는 최소 횟수 - 연산은 -1 +1 /2 /3 네가지를 이용
     * @return
     * @throws IOException
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= MAX; i++){
            arr[i] = -1;
        }
        arr[n] = 0;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()){
            int num = q.poll();
            if (num == 1){
                ans = arr[num];
                System.out.println(ans);
                break;
            }
            for (int i = 0; i < 4; i++){
                if (!possible(num,i)) continue;
                int newNum = calc(num, i);
                if (inRange(newNum) && arr[newNum] == -1) {
                    arr[newNum] = arr[num] + 1;
                    q.add(newNum);
                }
            }
        }
        return ans;
    }
}
