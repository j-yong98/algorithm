package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2517Test {
    @Test
    void solution() throws IOException {
        BOJ2517 boj2517 = new BOJ2517();
        String p = "8\n" +
                "2\n" +
                "8\n" +
                "10\n" +
                "7\n" +
                "1\n" +
                "9\n" +
                "4\n" +
                "15";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2517.solution();
    }
}