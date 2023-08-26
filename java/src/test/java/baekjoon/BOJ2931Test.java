package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2931Test {
    @Test
    void solution() throws IOException {
        BOJ2931 boj2931 = new BOJ2931();
        String p = "6 10\n" +
                "Z.1----4..\n" +
                "|.|....|..\n" +
                "|..14..M..\n" +
                "2-+++4....\n" +
                "..2323....\n" +
                "..........";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2931.solution();
    }
}