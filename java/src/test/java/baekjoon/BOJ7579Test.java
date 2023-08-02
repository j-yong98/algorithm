package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7579Test {
    @Test
    void solution() throws IOException {
        BOJ7579 boj7579 = new BOJ7579();
        String p = "5 60\n" +
                "30 10 20 35 40\n" +
                "3 0 3 5 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7579.solution();
    }
}