package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17503Test {
    @Test
    void solution() throws IOException {
        BOJ17503 boj17503 = new BOJ17503();
        String p = "3 9 5\n" +
                "2 5\n" +
                "4 6\n" +
                "3 3\n" +
                "4 3\n" +
                "1 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17503.solution();
    }
}