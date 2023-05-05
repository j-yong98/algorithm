package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2170Test {
    @Test
    void solution() throws IOException {
        BOJ2170 boj2170 = new BOJ2170();
        String p = "4\n" +
                "1 3\n" +
                "2 5\n" +
                "3 5\n" +
                "6 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2170.solution();
    }
}