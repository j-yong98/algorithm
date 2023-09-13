package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16978Test {
    @Test
    void solution() throws IOException {
        BOJ16978 boj16978 = new BOJ16978();
        String p = "5\n" +
                "1 2 3 4 5\n" +
                "7\n" +
                "1 2 5\n" +
                "2 0 1 3\n" +
                "2 1 1 3\n" +
                "1 4 2\n" +
                "2 0 2 5\n" +
                "2 1 2 5\n" +
                "2 2 2 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16978.solution();
    }
}