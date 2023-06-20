package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2003Test {
    @Test
    void solution() throws IOException {
        BOJ2003 boj2003 = new BOJ2003();
        String p = "10 5\n" +
                "1 2 3 4 2 5 3 1 1 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2003.solution();
    }
}