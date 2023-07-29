package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21921Test {
    @Test
    void solution() throws IOException {
        BOJ21921 boj21921 = new BOJ21921();
        String p = "7 5\n" +
                "1 1 1 1 1 5 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21921.solution();
    }
}