package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10830Test {
    @Test
    void solution() throws IOException {
        BOJ10830 boj10830 = new BOJ10830();
        String p = "3 3\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "7 8 9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10830.solution();
    }
}