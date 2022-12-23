package others;

import java.util.Scanner;

public class Problem22 {
    int n;
    int[] arr;
    public int solution(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 2; i <= 100; i++){
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if (arr[j] % i == 0) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
        return ans;
    }
}
