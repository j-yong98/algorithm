package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11866Test {
    @Test
    void solution() throws IOException {
        BOJ11866 boj11866 = new BOJ11866();
        String p = "7 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11866.solution();
    }
}