package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17406Test {
    @Test
    void solution() throws IOException {
        BOJ17406 boj17406 = new BOJ17406();
        String p = "5 6 2\n" +
                "1 2 3 2 5 6\n" +
                "3 8 7 2 1 3\n" +
                "8 2 3 1 4 5\n" +
                "3 4 5 1 1 1\n" +
                "9 3 2 1 4 3\n" +
                "3 4 2\n" +
                "4 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17406.solution();
    }
}