package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2133Test {
    @Test
    void solution() throws IOException {
        BOJ2133 boj2133 = new BOJ2133();
        String p = "30";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2133.solution();
    }

}