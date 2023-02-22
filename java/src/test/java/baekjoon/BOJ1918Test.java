package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1918Test {
    @Test
    void solution() throws IOException {
        BOJ1918 boj1918 = new BOJ1918();
        String p = "A+B*C";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1918.solution();
    }
}