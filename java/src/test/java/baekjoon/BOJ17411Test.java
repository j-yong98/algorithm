package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17411Test {
    @Test
    void solution() throws IOException {
        BOJ17411 boj17411 = new BOJ17411();
        String p = "10\n" +
                "3 2 1 6 5 4 10 9 8 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17411.solution();
    }
}