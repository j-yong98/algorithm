package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16173Test {
    @Test
    void solution() throws IOException {
        BOJ16173 boj16173 = new BOJ16173();
        String p = "3\n" +
                "1 1 10\n" +
                "1 5 1\n" +
                "2 2 -1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16173.solution();
    }
}