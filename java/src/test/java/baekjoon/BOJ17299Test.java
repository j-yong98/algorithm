package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17299Test {
    @Test
    void solution() throws IOException {
        BOJ17299 boj17299 = new BOJ17299();
        String p = "7\n" +
                "1 1 2 3 4 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17299.solution();
    }
}