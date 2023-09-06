package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ8547Test {
    @Test
    void solution() throws IOException {
        BOJ8547 boj8547 = new BOJ8547();
        String p = "10\n" +
                "3 3 3 3 3 3 3 3 3 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj8547.solution();
    }
}