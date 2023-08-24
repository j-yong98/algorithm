package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2669 {
    int N;
    int[] arr;
    List<Integer> ans = new ArrayList<>();
    boolean[] visited;

    /**
     * 숫자 고르기
     * 싸이클 발생 여부 확인 후 싸이클 발생하면 정답 담기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++)
            dfs(i, i);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) continue;
            ans.add(i);
        }
        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++)
            sb.append(ans.get(i)).append("\n");
        System.out.print(sb);
        br.close();
    }

    private boolean dfs(int start, int val) {
        if (visited[val]) {
            if (start == val)
                return true;
            return false;
        }
        visited[val] = true;
        boolean flag = dfs(start, arr[val]);
        if (!flag)
            visited[val] = false;
        return flag;
    }
}
