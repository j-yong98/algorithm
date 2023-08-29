package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14725Test {
    @Test
    void solution() throws IOException {
        BOJ14725 boj14725 = new BOJ14725();
        String p = "4\n" +
                "2 KIWI BANANA\n" +
                "2 KIWI APPLE\n" +
                "2 APPLE APPLE\n" +
                "3 APPLE BANANA KIWI";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14725.solution();
    }
}