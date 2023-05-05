package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11000Test {
    @Test
    void solution() throws IOException {
        BOJ11000 boj11000 = new BOJ11000();
        String p = "3\n" +
                "1 3\n" +
                "2 4\n" +
                "3 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11000.solution();
    }
}