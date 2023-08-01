package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1991 {
    int n;
    List<Character>[] tree;
    List<Character>[] res;

    /**
     * 트리 순회
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        res = new List[3];
        for (int i = 0; i < 3; i++)
            res[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            char p = line[0].charAt(0);
            char c1 = line[1].charAt(0);
            char c2 = line[2].charAt(0);
            tree[p - 65].add(c1);
            tree[p - 65].add(c2);
        }
        searchTree(0);
        for (int i = 0; i < 3; i++) {
            for (Character node : res[i])
                sb.append((char) (node));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void searchTree(int parent) {
        res[0].add((char) (parent + 65));
        if (tree[parent].get(0) != '.') searchTree(tree[parent].get(0) - 65);
        res[1].add((char) (parent + 65));
        if (tree[parent].get(1) != '.') searchTree(tree[parent].get(1) - 65);
        res[2].add((char) (parent + 65));
    }
}
