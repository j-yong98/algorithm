package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6236Test {
    @Test
    void solution() throws IOException {
        BOJ6236 boj6236 = new BOJ6236();
        String p = "7 5\n" +
                "100\n" +
                "400\n" +
                "300\n" +
                "100\n" +
                "500\n" +
                "101\n" +
                "400";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6236.solution();
    }
}