package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2631Test {
    @Test
    void solution() throws IOException {
        BOJ2631 boj2631 = new BOJ2631();
        String p = "7\n" +
                "3\n" +
                "7\n" +
                "5\n" +
                "2\n" +
                "6\n" +
                "1\n" +
                "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2631.solution();
    }
}