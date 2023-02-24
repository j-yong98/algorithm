package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ5430Test {
    @Test
    void solution() throws IOException {
        BOJ5430 boj5430 = new BOJ5430();
        String p = "1\n" +
                "RD\n" +
                "0\n" +
                "[]";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5430.solution();
    }
}