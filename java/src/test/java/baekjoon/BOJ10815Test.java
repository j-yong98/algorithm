package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ10815Test {
    @Test
    void solution() throws IOException {
        BOJ10815 boj10815 = new BOJ10815();
        String p = "5\n" +
                "6 3 2 10 -10\n" +
                "8\n" +
                "10 9 -5 2 3 4 5 -10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10815.solution();
    }
}