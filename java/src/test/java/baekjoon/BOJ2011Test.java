package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2011Test {

    @Test
    void solution() throws IOException {
        BOJ2011 boj2011 = new BOJ2011();
        String p = "1010";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2011.solution();
    }
}