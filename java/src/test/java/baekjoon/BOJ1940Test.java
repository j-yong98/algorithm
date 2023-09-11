package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1940Test {

    @Test
    void solution() throws IOException {
        BOJ1940 boj1940 = new BOJ1940();
        String p = "6\n" +
                "9\n" +
                "2 7 4 1 5 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1940.solution();
    }
}