package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17352Test {
    @Test
    void solution() throws IOException {
        BOJ17352 boj17352 = new BOJ17352();
        String p = "4\n" +
                "1 2\n" +
                "1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17352.solution();
    }
}