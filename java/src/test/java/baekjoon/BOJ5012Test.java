package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5012Test {
    @Test
    void solution() throws IOException {
        BOJ5012 boj5012 = new BOJ5012();
        String p = "4\n" +
                "3 3 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5012.solution();
    }
}