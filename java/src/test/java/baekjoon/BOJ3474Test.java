package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3474Test {
    @Test
    void solution() throws IOException {
        BOJ3474 boj3474 = new BOJ3474();
        String p = "6\n" +
                "3\n" +
                "60\n" +
                "100\n" +
                "1024\n" +
                "23456\n" +
                "8735373";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3474.solution();
    }
}