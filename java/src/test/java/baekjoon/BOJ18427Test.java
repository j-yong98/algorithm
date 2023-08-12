package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18427Test {
    @Test
    void solution() throws IOException {
        BOJ18427 boj18427 = new BOJ18427();
        String p = "3 3 5\n" +
                "2 3 5\n" +
                "3 5\n" +
                "1 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18427.solution();
    }
}