package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ14501Test {
    @Test
    void solution() throws IOException {
        BOJ14501 boj14501 = new BOJ14501();
        String p = "10\n" +
                "5 50\n" +
                "4 40\n" +
                "3 30\n" +
                "2 20\n" +
                "1 10\n" +
                "1 10\n" +
                "2 20\n" +
                "3 30\n" +
                "4 40\n" +
                "5 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14501.solution();
    }
}