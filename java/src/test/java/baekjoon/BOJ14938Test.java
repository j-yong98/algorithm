package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14938Test {
    @Test
    void solution() throws IOException {
        BOJ14938 boj14938 = new BOJ14938();
        String p = "5 5 4\n" +
                "5 7 8 2 3\n" +
                "1 4 5\n" +
                "5 2 4\n" +
                "3 2 3\n" +
                "1 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14938.solution();
    }
}