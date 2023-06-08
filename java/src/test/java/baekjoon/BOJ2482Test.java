package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2482Test {
    @Test
    void solution() throws IOException {
        BOJ2482 boj2482 = new BOJ2482();
        String p = "7\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2482.solution();
    }
}