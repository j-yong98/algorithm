package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1280Test {
    @Test
    void solution() throws IOException {
        BOJ1280 boj1280 = new BOJ1280();
        String p = "10\n" +
                "4\n" +
                "59\n" +
                "94\n" +
                "89\n" +
                "4\n" +
                "59\n" +
                "94\n" +
                "89\n" +
                "4\n" +
                "59";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1280.solution();
    }
}