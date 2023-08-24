package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15961Test {
    @Test
    void solution() throws IOException {
        BOJ15961 boj15961 = new BOJ15961();
        String p = "8 30 4 30\n" +
                "7\n" +
                "9\n" +
                "7\n" +
                "30\n" +
                "2\n" +
                "7\n" +
                "9\n" +
                "25";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15961.solution();
    }
}