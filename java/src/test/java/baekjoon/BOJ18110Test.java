package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18110Test {
    @Test
    void solution() throws IOException {
        BOJ18110 boj18110 = new BOJ18110();
        String p = "10\n" +
                "1\n" +
                "13\n" +
                "12\n" +
                "15\n" +
                "3\n" +
                "16\n" +
                "13\n" +
                "12\n" +
                "14\n" +
                "15";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18110.solution();
    }
}