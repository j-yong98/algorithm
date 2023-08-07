package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9019Test {
    @Test
    void solution() throws IOException {
        BOJ9019 boj9019 = new BOJ9019();
        String p = "3\n" +
                "1234 3412\n" +
                "1000 1\n" +
                "1 16";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9019.solution();
    }
}