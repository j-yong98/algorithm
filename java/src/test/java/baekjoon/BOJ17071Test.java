package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17071Test {
    @Test
    void solution() throws IOException {
        BOJ17071 boj17071 = new BOJ17071();
        String p = "27297 339652\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17071.solution();
    }
}