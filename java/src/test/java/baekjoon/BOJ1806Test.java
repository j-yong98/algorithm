package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1806Test {
    @Test
    void solution() throws IOException {
        BOJ1806 boj1806 = new BOJ1806();
        String p = "10 15\n" +
                "5 1 3 5 10 7 4 9 2 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1806.solution();
    }
}