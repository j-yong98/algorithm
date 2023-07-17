package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2616Test {
    @Test
    void solution() throws IOException {
        BOJ2616 boj2616 = new BOJ2616();
        String p = "7\n" +
                "35 40 50 10 30 45 60\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2616.solution();
    }
}