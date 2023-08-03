package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2023Test {
    @Test
    void solution() throws IOException {
        BOJ2023 boj2023 = new BOJ2023();
        String p = "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2023.solution();
    }
}