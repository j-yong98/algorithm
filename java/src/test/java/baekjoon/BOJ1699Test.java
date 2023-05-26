package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1699Test {
    @Test
    void solution() throws IOException {
        BOJ1699 boj1699 = new BOJ1699();
        String p = "13";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1699.solution();
    }

}