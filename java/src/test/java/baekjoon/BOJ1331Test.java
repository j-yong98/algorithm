package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1331Test {
    @Test
    void solution() throws IOException {
        BOJ1331 boj1331 = new BOJ1331();
        String p = "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3\n" +
                "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3\n" +
                "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3\n" +
                "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3\n" +
                "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3\n" +
                "A1\n" +
                "C2\n" +
                "E3\n" +
                "F5\n" +
                "D4\n" +
                "B3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1331.solution();
    }
}