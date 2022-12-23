package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12 {
    int n;
    char[] arr;

    public String encoding(char[] arr){
        String res = "";
        int cnt = 1;
        char pre = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (pre == arr[i]) cnt++;
            else{
                res += pre;
                res += Integer.toString(cnt);
                pre = arr[i];
                cnt = 1;
            }
        }
        res += pre;
        res += Integer.toString(cnt);
//        System.out.println(res);
        return res;
    }

    private void shiftRight(){
        char tmp = arr[n-1];
        for (int i = n - 1; i >= 1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = tmp;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        n = s.length();
        arr= s.toCharArray();
        int ans = encoding(arr).length();
        for (int i = 0; i < n; i++){
            shiftRight();
            int res = encoding(arr).length();
            ans = Math.min(ans,res);
        }
        System.out.println(ans);
    }
}
