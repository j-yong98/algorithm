package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2665Test {
    @Test
    void solution() throws IOException {
        BOJ2665 boj2665 = new BOJ2665();
        String p = "8\n" +
                "11100110\n" +
                "11010010\n" +
                "10011010\n" +
                "11101100\n" +
                "01000111\n" +
                "00110001\n" +
                "11011000\n" +
                "11000111";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2665.solution();
    }
}