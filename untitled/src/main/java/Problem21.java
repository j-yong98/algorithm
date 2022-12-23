import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21 {
    int n;
    int[] arr;
    private int minDist(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++){
            min = Math.min(min,Math.abs(arr[i] - arr[i + 1]));
        }
        return min;
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = minDist();

        int ans = 0;
        for (int i = 0; i < n - 1; i++){
            if (Math.abs(arr[i] - arr[i+1]) == min){
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }
}
