package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11660Test {
    @Test
    void solution() throws IOException {
        BOJ11660 boj11660 = new BOJ11660();
        String p = "4 3\n" +
                "1 2 3 4\n" +
                "2 3 4 5\n" +
                "3 4 5 6\n" +
                "4 5 6 7\n" +
                "2 2 3 4\n" +
                "3 4 3 4\n" +
                "1 1 4 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11660.solution();
    }
}