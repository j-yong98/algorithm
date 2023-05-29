package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9465Test {
    @Test
    void solution() throws IOException {
        BOJ9465 boj9465 = new BOJ9465();
        String p = "2\n" +
                "5\n" +
                "50 10 100 20 40\n" +
                "30 50 70 10 60\n" +
                "7\n" +
                "10 30 10 50 100 20 40\n" +
                "20 40 30 50 60 20 80";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9465.solution();
    }
}