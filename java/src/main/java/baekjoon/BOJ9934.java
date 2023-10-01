package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ9934 {
    int N;
    int K;
    int[] arr;
    List<Integer>[] ans;

    /**
     * 완전 이진 트리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        ans = new List[K];
        for (int i = 0; i < K; i++)
            ans[i] = new ArrayList();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr.length;
        findBinaryTree(0, N - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int n : ans[i])
                sb.append(n).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void findBinaryTree(int s, int e, int k) {
        if (s > e) return;
        int mid = (s + e) >> 1;
        ans[k].add(arr[mid]);
        findBinaryTree(s, mid - 1, k + 1);
        findBinaryTree(mid + 1, e, k + 1);
    }
}
