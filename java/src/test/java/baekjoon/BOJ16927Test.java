package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16927Test {
    @Test
    void solution() throws IOException {
        BOJ16927 boj16927 = new BOJ16927();
        String p = "4 4 2\n" +
                "1 2 3 4\n" +
                "5 6 7 8\n" +
                "9 10 11 12\n" +
                "13 14 15 16";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16927.solution();
    }
}