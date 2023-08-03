package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11057Test {
    @Test
    void solution() throws IOException {
        BOJ11057 boj11057 = new BOJ11057();
        String p = "1000";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11057.solution();
    }
}