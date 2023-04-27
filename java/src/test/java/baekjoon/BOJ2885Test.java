package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2885Test {
    @Test
    void solution() throws IOException {
        BOJ2885 boj2885 = new BOJ2885();
        String p = "17";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2885.solution();
    }
}