package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1989Test {
    @Test
    void solution() throws IOException {
        BOJ1989 boj1989 = new BOJ1989();
        String p = "6\n" +
                "3 1 6 4 5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1989.solution();
    }
}