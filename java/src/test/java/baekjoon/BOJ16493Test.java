package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16493Test {
    @Test
    void solution() throws IOException {
        BOJ16493 boj16493 = new BOJ16493();
        String p = "7 7\n" +
                "3 10\n" +
                "5 20\n" +
                "1 10\n" +
                "1 20\n" +
                "2 15\n" +
                "4 40\n" +
                "2 200";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16493.solution();
    }
}