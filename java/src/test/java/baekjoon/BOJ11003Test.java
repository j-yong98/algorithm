package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11003Test {
    @Test
    void solution() throws IOException {
        BOJ11003 boj11003 = new BOJ11003();
        String p = "12 3\n" +
                "1 5 2 3 6 2 3 7 3 5 2 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11003.solution();
    }
}