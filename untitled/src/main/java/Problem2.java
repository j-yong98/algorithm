import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {
    int n,m;
    int[][] arr;
    private int check(){
        int cnt = 0;

        /**
         * 행에 같은 숫자가 m개 이상 있나 검사
         */
        for (int i = 0; i < n; i++){
            int n_cnt = 1;
            int pre = arr[i][0];
            for (int j = 1; j < n; j++){
                if (arr[i][j] == pre){
                    n_cnt++;
                    pre = arr[i][j];
                }
                else{
                    if (n_cnt >= m){
                        break;
                    }
                    n_cnt = 1;
                    pre = arr[i][j];
                }
            }
            if (n_cnt >= m){
                cnt++;
            }
        }
        /**
         * 열에 같은 숫자가 m개 이상 있나 검사
         */
        for (int i = 0; i < n; i++){
            int n_cnt = 1;
            int pre = arr[0][i];
            for (int j = 1; j < n; j++){
                if (arr[j][i] == pre){
                    n_cnt++;
                    pre = arr[j][i];
                }
                else{
                    if (n_cnt >= m){
                        break;
                    }
                    n_cnt = 1;
                    pre = arr[j][i];
                }
            }
            if (n_cnt >= m){
                cnt++;
            }
        }
        return cnt;
    }
    public int problem2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return check();
    }
}
