package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1874Test {
    @Test
    void solution() throws IOException {
        BOJ1874 boj1874 = new BOJ1874();
        String p = "5\n" +
                "1\n" +
                "2\n" +
                "5\n" +
                "3\n" +
                "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1874.solution();
    }
}