package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7469Test {
    @Test
    void solution() throws IOException {
        BOJ7469 boj7469 = new BOJ7469();
        String p = "7 3\n" +
                "1 5 2 6 3 7 4\n" +
                "2 5 3\n" +
                "4 4 1\n" +
                "1 7 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7469.solution();
    }
}