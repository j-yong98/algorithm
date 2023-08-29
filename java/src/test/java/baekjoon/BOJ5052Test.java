package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5052Test {
    @Test
    void solution() throws IOException {
        BOJ5052 boj5052 = new BOJ5052();
        String p = "2\n" +
                "3\n" +
                "911\n" +
                "97625999\n" +
                "91125426\n" +
                "5\n" +
                "113\n" +
                "12340\n" +
                "123440\n" +
                "12345\n" +
                "98346";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5052.solution();
    }
}