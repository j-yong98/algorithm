package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3967Test {
    @Test
    void solution() throws IOException {
        BOJ3967 boj3967 = new BOJ3967();
        String p = "....x....\n" +
                ".A.I.D.x.\n" +
                "..x...x..\n" +
                ".x.x.x.x.\n" +
                "....x....";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3967.solution();
    }
}