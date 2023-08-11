package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14621Test {
    @Test
    void solution() throws IOException {
        BOJ14621 boj14621 = new BOJ14621();
        String p = "5 7\n" +
                "M W W W M\n" +
                "1 2 12\n" +
                "1 3 10\n" +
                "4 2 5\n" +
                "5 2 5\n" +
                "2 5 10\n" +
                "3 4 3\n" +
                "5 4 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14621.solution();
    }
}