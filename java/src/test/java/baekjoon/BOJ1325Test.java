package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1325Test {
    @Test
    void solution() throws IOException {
        BOJ1325 boj1325 = new BOJ1325();
        String p = "5 4\n" +
                "3 1\n" +
                "3 2\n" +
                "4 3\n" +
                "5 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1325.solution();
    }
}