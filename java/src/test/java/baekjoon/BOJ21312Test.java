package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21312Test {
    @Test
    void solution() throws IOException {
        BOJ21312 boj21312 = new BOJ21312();
        String p = "22 44 88";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21312.solution();
    }
}