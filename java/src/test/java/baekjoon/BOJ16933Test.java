package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16933Test {
    @Test
    void solution() throws IOException {
        BOJ16933 boj16933 = new BOJ16933();
        String p = "6 4 2\n" +
                "0100\n" +
                "1110\n" +
                "1000\n" +
                "0000\n" +
                "0111\n" +
                "0000";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16933.solution();
    }
}