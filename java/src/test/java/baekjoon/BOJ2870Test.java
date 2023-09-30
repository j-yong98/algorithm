package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2870Test {
    @Test
    void solution() throws IOException {
        BOJ2870 boj2870 = new BOJ2870();
        String p = "3\n" +
                "43silos0\n" +
                "708aa44a\n" +
                "231";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2870.solution();
    }
}