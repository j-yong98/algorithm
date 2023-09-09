package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1365Test {
    @Test
    void solution() throws IOException {
        BOJ1365 boj1365 = new BOJ1365();
        String p = "4\n" +
                "2 3 4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1365.solution();
    }
}