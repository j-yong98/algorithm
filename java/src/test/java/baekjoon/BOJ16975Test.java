package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16975Test {
    @Test
    void solution() throws IOException {
        BOJ16975 boj16975 = new BOJ16975();
        String p = "5\n" +
                "1 2 3 4 5\n" +
                "4\n" +
                "1 3 4 6\n" +
                "2 3\n" +
                "1 1 3 -2\n" +
                "2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16975.solution();
    }
}