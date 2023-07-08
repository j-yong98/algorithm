package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17298Test {
    @Test
    void solution() throws IOException {
        BOJ17298 boj17298 = new BOJ17298();
        String p = "4\n" +
                "9 5 4 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17298.solution();
    }
}