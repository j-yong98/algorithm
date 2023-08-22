package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3273Test {
    @Test
    void solution() throws IOException {
        BOJ3273 boj3273 = new BOJ3273();
        String p = "9\n" +
                "5 12 7 10 9 1 2 3 11\n" +
                "13";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3273.solution();
    }
}