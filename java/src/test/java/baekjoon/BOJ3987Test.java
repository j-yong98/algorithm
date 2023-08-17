package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3987Test {
    @Test
    void solution() throws IOException {
        BOJ3987 boj3987 = new BOJ3987();
        String p = "5 5\n" +
                "../.\\\n" +
                ".....\n" +
                ".C...\n" +
                "...C.\n" +
                "\\.../\n" +
                "3 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3987.solution();
    }
}