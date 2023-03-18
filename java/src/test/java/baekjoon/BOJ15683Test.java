package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ15683Test {
    @Test
    void solution() throws IOException {
        BOJ15683 boj15683 = new BOJ15683();
        String p = "3 7\n" +
                "4 0 0 0 0 0 0\n" +
                "0 0 0 2 0 0 0\n" +
                "0 0 0 0 0 0 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15683.solution();
    }
}