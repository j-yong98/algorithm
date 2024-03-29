package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {
    Node tree;
    StringBuilder sb = new StringBuilder();

    /**
     * 이진 검색 트리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (true) {
            line = br.readLine();
            if (line == null) break;
            int value = Integer.parseInt(line);
            if (tree == null)
                tree = new Node(value);
            else
                findPos(tree, value);
        }
        postOrder(tree);
        System.out.print(sb);
        br.close();
    }

    private void postOrder(Node parent) {
        if (parent.left == null && parent.right == null) {
            sb.append(parent.value).append("\n");
            return;
        }
        if (parent.left != null)
            postOrder(parent.left);
        if (parent.right != null)
            postOrder(parent.right);
        sb.append(parent.value).append("\n");
    }

    private void findPos(Node parent, int value) {
        if (parent.left == null && parent.value > value)
            parent.left = new Node(value);
        else if (parent.right == null && parent.value < value)
            parent.right = new Node(value);
        else {
            if (parent.value > value)
                findPos(parent.left, value);
            else
                findPos(parent.right, value);
        }
    }
    static class Node {
        int value;
        Node left = null;
        Node right = null;

        public Node() {
            value = -1;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
