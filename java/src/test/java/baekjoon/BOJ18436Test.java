package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18436Test {
    @Test
    void solution() throws IOException {
        BOJ18436 boj18436 = new BOJ18436();
        String p = "6\n" +
                "1 2 3 4 5 6\n" +
                "4\n" +
                "2 2 5\n" +
                "3 1 4\n" +
                "1 5 4\n" +
                "2 1 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18436.solution();
    }
}