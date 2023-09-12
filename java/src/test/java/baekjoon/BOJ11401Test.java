package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11401Test {
    @Test
    void solution() throws IOException {
        BOJ11401 boj11401 = new BOJ11401();
        String p = "5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11401.solution();
    }
}