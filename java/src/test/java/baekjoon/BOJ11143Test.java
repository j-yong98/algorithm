package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11143Test {
    @Test
    void solution() throws IOException {
        BOJ11143 boj11143 = new BOJ11143();
        String p = "1\n" +
                "7 5 3\n" +
                "P 2 1\n" +
                "P 3 3\n" +
                "P 4 7\n" +
                "Q 1 4\n" +
                "P 7 6\n" +
                "Q 4 4\n" +
                "P 6 4\n" +
                "Q 1 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11143.solution();
    }
}