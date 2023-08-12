package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18222Test {
    @Test
    void solution() throws IOException {
        BOJ18222 boj18222 = new BOJ18222();
        String p = "12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18222.solution();
    }
}