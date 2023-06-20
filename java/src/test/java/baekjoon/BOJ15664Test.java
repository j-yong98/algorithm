package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15664Test {
    @Test
    void solution() throws IOException {
        BOJ15664 boj15664 = new BOJ15664();
        String p = "4 4\n" +
                "1 1 2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15664.solution();
    }
}