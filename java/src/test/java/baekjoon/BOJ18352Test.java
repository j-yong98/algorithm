package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18352Test {
    @Test
    void solution() throws IOException {
        BOJ18352 boj18352 = new BOJ18352();
        String p = "4 4 2 1\n" +
                "1 2\n" +
                "1 3\n" +
                "2 3\n" +
                "2 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18352.solution();
    }
}