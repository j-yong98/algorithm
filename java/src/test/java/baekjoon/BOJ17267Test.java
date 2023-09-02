package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17267Test {
    @Test
    void solution() throws IOException {
        BOJ17267 boj17267 = new BOJ17267();
        String p = "5 5\n" +
                "1 1\n" +
                "00000\n" +
                "00000\n" +
                "02100\n" +
                "10000\n" +
                "00000";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17267.solution();
    }
}