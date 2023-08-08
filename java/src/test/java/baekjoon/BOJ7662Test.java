package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7662Test {
    @Test
    void solution() throws IOException {
        BOJ7662 boj7662 = new BOJ7662();
        String p = "2\n" +
                "7\n" +
                "I 16\n" +
                "I -5643\n" +
                "D -1\n" +
                "D 1\n" +
                "D 1\n" +
                "I 123\n" +
                "D -1\n" +
                "9\n" +
                "I -45\n" +
                "I 653\n" +
                "D 1\n" +
                "I -642\n" +
                "I 45\n" +
                "I 97\n" +
                "D 1\n" +
                "D -1\n" +
                "I 333";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7662.solution();
    }
}