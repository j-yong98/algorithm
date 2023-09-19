package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1572Test {
    @Test
    void solution() throws IOException {
        BOJ1572 boj1572 = new BOJ1572();
        String p = "10 3\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1572.solution();
    }
}