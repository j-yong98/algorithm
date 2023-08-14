package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17845Test {
    @Test
    void solution() throws IOException {
        BOJ17845 boj17845 = new BOJ17845();
        String p = "80 3\n" +
                "650 40\n" +
                "700 60\n" +
                "60 40";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17845.solution();
    }
}