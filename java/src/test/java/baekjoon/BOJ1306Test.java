package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1306Test {
    @Test
    void solution() throws IOException {
        BOJ1306 boj1306 = new BOJ1306();
        String p = "5 2\n" +
                "1 1 1 3 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1306.solution();
    }
}