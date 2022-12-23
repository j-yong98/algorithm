import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem16 {
    int n,m;
    int[] arr;
    private void boom(int s, int e){
        for (int i = 0; i < n; i++){
            if (i >= s && i < e) arr[i] = 0;
        }
    }
    private void print(){
        for (int i : arr) {
            if (i == 0) continue;
            System.out.println(i);
        }
    }
    private void fall(){
        int[] tmp = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] == 0) continue;
            tmp[idx++] = arr[i];
        }
        for (int i = 0; i < n; i++){
            arr[i] = tmp[i];
        }
    }
    private void check(int l){
        if (l == n) return;
        boolean flag = false;
        for (int i = 0; i < n; i++){
            if (arr[i] == 0) continue;
            int cnt = 1;
            for (int j = i + 1; j < n; j++){
                if (arr[i] != arr[j]) break;
                cnt++;
            }
            if (cnt >= m) {
                boom(i,i+cnt);
                flag = true;
            }
        }
        if (flag) {
            fall();
            check(l+1);
        }
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check(0);
        System.out.println(Arrays.stream(arr).filter(i -> i != 0).count());
        print();
        return Long.valueOf(Arrays.stream(arr).filter(i -> i != 0).count()).intValue();
    }
}
