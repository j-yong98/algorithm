package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ9935Test {
    @Test
    void solution() throws IOException {
        BOJ9935 boj9935 = new BOJ9935();
        String p = "12ab112ab2ab\n" +
                "12ab";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9935.solution();
    }
}