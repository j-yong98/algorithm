package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20061Test {
    @Test
    void solution() throws IOException {
        BOJ20061 boj20061 = new BOJ20061();
        String p = "8\n" +
                "1 1 1\n" +
                "2 3 0\n" +
                "3 2 2\n" +
                "3 2 3\n" +
                "3 1 3\n" +
                "2 0 0\n" +
                "3 2 0\n" +
                "3 1 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20061.solution();
    }
}