package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7578Test {
    @Test
    void solution() throws IOException {
        BOJ7578 boj7578 = new BOJ7578();
        String p = "5\n" +
                "132 392 311 351 231\n" +
                "392 351 132 311 231";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7578.solution();
    }
}