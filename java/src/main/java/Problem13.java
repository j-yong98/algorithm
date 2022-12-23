import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem13 {
    int n;
    int r,c,m1,m2,m3,m4,dir;
    int[][] arr;


    private void rotate(){
        int[] dy = {-1,-1,1,1};
        int[] dx = {1,-1,-1,1};
        int[] move = {m1,m2,m3,m4};
        int pre = arr[r][c];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < move[i]; j++){
                int y = r + dy[i];
                int x = c + dx[i];
                if (dir == 0) {
                    int tmp = arr[y][x];
                    arr[y][x] = pre;
                    pre = tmp;
                }
                else{
                    arr[r][c] = arr[y][x];
                    if (i == 3 && j == move[i]-1) arr[r][c] = pre;
                }
                r = y;
                c = x;
            }
        }

    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());
        m4 = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        rotate();

        for (int[] ints : arr) {
            List<String> collect = Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ",collect));
        }
    }
}
