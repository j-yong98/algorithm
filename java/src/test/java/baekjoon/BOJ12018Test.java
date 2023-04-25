package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12018Test {
    @Test
    void solution() throws IOException {
        BOJ12018 boj12018 = new BOJ12018();
        String p = "5 76\n" +
                "5 4 \n" +
                "36 25 1 36 36\n" +
                "4 4\n" +
                "30 24 25 20\n" +
                "6 4\n" +
                "36 36 36 36 36 36\n" +
                "2 4\n" +
                "3 7\n" +
                "5 4\n" +
                "27 15 26 8 14";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12018.solution();
    }
}