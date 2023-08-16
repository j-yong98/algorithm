package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1207Test {
    @Test
    void solution() throws IOException {
        BOJ1207 boj1207 = new BOJ1207();
        String p = "5\n" +
                "2 5\n" +
                "....#\n" +
                "#####\n" +
                "1 5\n" +
                "#####\n" +
                "1 5\n" +
                "#####\n" +
                "1 5\n" +
                "#####\n" +
                "1 4\n" +
                "####";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1207.solution();
    }
}