package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3109Test {
    @Test
    void solution() throws IOException {
        BOJ3109 boj3109 = new BOJ3109();
        String p = "6 10\n" +
                "..x.......\n" +
                ".....x....\n" +
                ".x....x...\n" +
                "...x...xx.\n" +
                "..........\n" +
                "....x.....";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3109.solution();
    }
}