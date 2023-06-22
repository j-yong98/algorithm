package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1339Test {
    @Test
    void solution() throws IOException {
        BOJ1339 boj1339 = new BOJ1339();
        String p = "2\n" +
                "GCF\n" +
                "ACDEB";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1339.solution();
    }
}