package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11403Test {
    @Test
    void solution() throws IOException {
        BOJ11403 boj11403 = new BOJ11403();
        String p = "7\n" +
                "0 0 0 1 0 0 0\n" +
                "0 0 0 0 0 0 1\n" +
                "0 0 0 0 0 0 0\n" +
                "0 0 0 0 1 1 0\n" +
                "1 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 1\n" +
                "0 0 1 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11403.solution();
    }
}