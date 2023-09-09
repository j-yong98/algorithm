package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12738Test {
    @Test
    void solution() throws IOException {
        BOJ12738 boj12738 = new BOJ12738();
        String p = "6\n" +
                "10 20 10 30 20 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12738.solution();
    }
}