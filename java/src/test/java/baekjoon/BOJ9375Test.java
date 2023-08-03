package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9375Test {
    @Test
    void solution() throws IOException {
        BOJ9375 boj9375 = new BOJ9375();
        String p = "2\n" +
                "3\n" +
                "hat headgear\n" +
                "sunglasses eyewear\n" +
                "turban headgear\n" +
                "3\n" +
                "mask face\n" +
                "sunglasses face\n" +
                "makeup face";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9375.solution();
    }
}