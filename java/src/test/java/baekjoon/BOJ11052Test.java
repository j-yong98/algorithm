package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11052Test {
    @Test
    void solution() throws IOException {
        BOJ11052 boj11052 = new BOJ11052();
        String p = "4\n" +
                "1 5 6 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11052.solution();
    }
}