package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1722Test {
    @Test
    void solution() throws IOException {
        BOJ1722 boj1722 = new BOJ1722();
        String p = "4\n" +
                "2 1 3 2 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1722.solution();
    }
}