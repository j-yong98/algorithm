package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20055Test {
    @Test
    void solution() throws IOException {
        BOJ20055 boj20055 = new BOJ20055();
        String p = "4 5\n" +
                "10 1 10 6 3 4 8 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20055.solution();
    }
}