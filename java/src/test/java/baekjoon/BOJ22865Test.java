package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ22865Test {
    @Test
    void solution() throws IOException {
        BOJ22865 boj22865 = new BOJ22865();
        String p = "6\n" +
                "1 2 5\n" +
                "8\n" +
                "1 2 1\n" +
                "2 3 4\n" +
                "1 4 2\n" +
                "2 5 3\n" +
                "1 6 5\n" +
                "5 6 2\n" +
                "3 4 2\n" +
                "4 5 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj22865.solution();
    }
}