package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18185Test {
    @Test
    void solution() throws IOException {
        BOJ18185 boj18185 = new BOJ18185();
        String p = "4\n" +
                "2 3 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18185.solution();
    }
}