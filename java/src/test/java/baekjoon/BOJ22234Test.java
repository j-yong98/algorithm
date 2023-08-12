package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ22234Test {
    @Test
    void solution() throws IOException {
        BOJ22234 boj22234 = new BOJ22234();
        String p = "1 5 7\n" +
                "1 6\n" +
                "1\n" +
                "3 1 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj22234.solution();
    }
}