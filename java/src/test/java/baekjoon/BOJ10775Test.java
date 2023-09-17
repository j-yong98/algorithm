package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10775Test {
    @Test
    void solution() throws IOException {
        BOJ10775 boj10775 = new BOJ10775();
        String p = "4\n" +
                "3\n" +
                "4\n" +
                "1\n" +
                "1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10775.solution();
    }
}