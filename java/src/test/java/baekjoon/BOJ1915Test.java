package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1915Test {
    @Test
    void solution() throws IOException {
        BOJ1915 boj1915 = new BOJ1915();
        String p = "4 4\n" +
                "0100\n" +
                "0111\n" +
                "1110\n" +
                "0010";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1915.solution();
    }
}