package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1107Test {
    @Test
    void solution() throws IOException {
        BOJ1107 boj1107 = new BOJ1107();
        String p = "80000\n" +
                "2\n" +
                "8 9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1107.solution();
    }
}