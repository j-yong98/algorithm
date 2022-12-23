package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10 {
    private int n,m,Q;
    private int[][] arr;

    private int[] visited;
    public int[][] shiftLeft(int[][] arr, int n, int m,int r){
        int tmp = arr[r][0];
        for (int i = 0; i < m-1; i++){
            arr[r][i] = arr[r][i+1];
        }
        arr[r][m-1] = tmp;
        return arr;
    }
    public int[][] shiftRight(int[][] arr,int n, int m, int r){
        int tmp = arr[r][m-1];
        for (int i = m-1; i >= 1; i--){
            arr[r][i] = arr[r][i-1];
        }
        arr[r][0] = tmp;
        return arr;
    }

    private void shiftLeft(int r){
        int tmp = arr[r][0];
        for (int i = 0; i < m-1; i++){
            arr[r][i] = arr[r][i+1];
        }
        arr[r][m-1] = tmp;
    }
    private void shiftRight(int r){
        int tmp = arr[r][m-1];
        for (int i = m-1; i >= 1; i--){
            arr[r][i] = arr[r][i-1];
        }
        arr[r][0] = tmp;
    }

    private void move(int r, String dir){
        visited[r] = 1;
        if (dir.equals("L")){
            shiftRight(r);
        }
        else{
            shiftLeft(r);
        }
        int preRow = r - 1;
        int nextRow = r + 1;
        String nextDir = dir.equals("L") ? "R" : "L";
        if (preRow >= 0 && visited[preRow] == 0){
            boolean flag = false;
            for (int i = 0; i < m; i++){
                if (arr[r][i] == arr[preRow][i]) flag = true;
            }
            if (flag) move(preRow,nextDir);
        }
        if (nextRow < n && visited[nextRow] == 0){
            boolean flag = false;
            for (int i = 0; i < m; i++){
                if (arr[r][i] == arr[nextRow][i]) flag = true;
            }
            if (flag) move(nextRow,nextDir);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int q = 0; q < Q; q++){
            visited = new int[n];
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();
            move(r,dir);
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
