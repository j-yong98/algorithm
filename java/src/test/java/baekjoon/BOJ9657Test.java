package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9657Test {
    @Test
    void solution() throws IOException {
        BOJ9657 boj9657 = new BOJ9657();
        String p = "21";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9657.solution();
    }
}