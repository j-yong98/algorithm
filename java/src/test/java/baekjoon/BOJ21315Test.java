package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21315Test {
    @Test
    void solution() throws IOException {
        BOJ21315 boj21315 = new BOJ21315();
        String p = "5\n" +
                "1 3 5 4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21315.solution();
    }
}