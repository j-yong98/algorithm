package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1849Test {
    @Test
    void solution() throws IOException {
        BOJ1849 boj1849 = new BOJ1849();
        String p = "8\n" +
                "5\n" +
                "0\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "0\n" +
                "0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1849.solution();
    }
}