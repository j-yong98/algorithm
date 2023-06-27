package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14442Test {
    @Test
    void solution() throws IOException {
        BOJ14442 boj14442 = new BOJ14442();
        String p = "6 4 1\n" +
                "0100\n" +
                "1110\n" +
                "1000\n" +
                "0000\n" +
                "0111\n" +
                "0000";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14442.solution();
    }
}