package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9466Test {
    @Test
    void solution() throws IOException {
        BOJ9466 boj9466 = new BOJ9466();
        String p = "2\n" +
                "7\n" +
                "3 1 3 7 3 4 6\n" +
                "8\n" +
                "1 2 3 4 5 6 7 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9466.solution();
    }

}