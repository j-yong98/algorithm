package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13544Test {
    @Test
    void solution() throws IOException {
        BOJ13544 boj13544 = new BOJ13544();
        String p = "5\n" +
                "5 1 2 3 4\n" +
                "3\n" +
                "2 4 1\n" +
                "6 6 6\n" +
                "1 5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13544.solution();
    }
}