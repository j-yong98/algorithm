package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2669Test {
    @Test
    void solution() throws IOException {
        BOJ2669 boj2669 = new BOJ2669();
        String p = "7\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "5\n" +
                "5\n" +
                "4\n" +
                "6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2669.solution();
    }
}