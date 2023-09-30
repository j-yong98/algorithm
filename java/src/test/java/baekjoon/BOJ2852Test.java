package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2852Test {
    @Test
    void solution() throws IOException {
        BOJ2852 boj2852 = new BOJ2852();
        String p = "5\n" +
                "1 01:10\n" +
                "1 02:20\n" +
                "2 45:30\n" +
                "2 46:40\n" +
                "2 47:50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2852.solution();
    }
}