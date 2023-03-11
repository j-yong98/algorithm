package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ2605Test {
    @Test
    void solution() throws IOException {
        BOJ2605 boj2605 = new BOJ2605();
        String p = "5\n" +
                "0 1 1 3 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2605.solution();
    }
}