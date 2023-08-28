package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12851Test {
    @Test
    void solution() throws IOException {
        BOJ12851 boj12851 = new BOJ12851();
        String p = "5 17";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12851.solution();
    }
}