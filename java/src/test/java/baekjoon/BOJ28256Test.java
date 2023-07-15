package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ28256Test {
    @Test
    void solution() throws IOException {
        BOJ28256 boj28256 = new BOJ28256();
        String p = "6\n" +
                "OOO\n" +
                "O-O\n" +
                "XOO\n" +
                "1 7\n" +
                "XOO\n" +
                "O-O\n" +
                "XXO\n" +
                "2 1 4\n" +
                "OXO\n" +
                "O-X\n" +
                "XXO\n" +
                "3 1 1 2\n" +
                "XOX\n" +
                "O-O\n" +
                "XOX\n" +
                "4 1 1 1 1\n" +
                "XOO\n" +
                "O-O\n" +
                "OOX\n" +
                "1 6\n" +
                "OXX\n" +
                "O-O\n" +
                "XXO\n" +
                "3 1 1 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj28256.solution();
    }
}