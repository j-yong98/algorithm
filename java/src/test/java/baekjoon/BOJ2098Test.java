package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2098Test {
    @Test
    void solution() throws IOException {
        BOJ2098 boj2098 = new BOJ2098();
        String p = "4\n" +
                "0 10 15 20\n" +
                "5 0 9 10\n" +
                "6 13 0 12\n" +
                "8 8 9 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2098.solution();
    }
}