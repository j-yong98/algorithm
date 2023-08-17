package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17262 {
    int N;
    List<Node> nodes = new ArrayList<>();

    /**
     * 팬덤이 넘쳐흘러
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes.add(new Node(s, e));
        }
        Collections.sort(nodes, (a, b) -> a.e == b.e ? a.s - b.s : a.e - b.e);
        int start = nodes.get(0).e;
        int ans = 0;
        Collections.sort(nodes, (a, b) -> a.s == b.s ? b.e - a.e : b.s - a.s);
        int end = nodes.get(0).s;
        if (start < end)
            ans = end - start;
        System.out.println(ans);
    }

    static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
