package others;

public class Floyd {
    static final int INF = 999999999;
    public int[][] floyd(int n,int[][] edges){
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) arr[i][j] = 0;
                else arr[i][j] = INF;
            }
        }
        for (int i = 0; i < edges.length; i++){
            arr[edges[i][0]-1][edges[i][1]-1] = edges[i][2];
            arr[edges[i][1]-1][edges[i][0]-1] = edges[i][2];
        }

        for (int k = 0; k < 6;k++){
            for (int i = 0; i < 6; i++){
                for (int j = 0; j < 6; j++){
                    if (arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        return arr;
    }
}
