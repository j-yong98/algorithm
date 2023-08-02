package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17626Test {
    @Test
    void solution() throws IOException {
        BOJ17626 boj17626 = new BOJ17626();
        String p = "11339";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17626.solution();
    }
}