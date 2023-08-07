package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2981Test {
    @Test
    void solution() throws IOException {
        BOJ2981 boj2981 = new BOJ2981();
        String p = "3\n" +
                "6\n" +
                "34\n" +
                "38";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2981.solution();
    }
}