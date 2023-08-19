package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18769Test {
    @Test
    void solution() throws IOException {
        BOJ18769 boj18769 = new BOJ18769();
        String p = "3\n" +
                "2 3\n" +
                "1 3\n" +
                "3 1\n" +
                "2 4 2\n" +
                "2 2\n" +
                "1\n" +
                "1\n" +
                "2 2\n" +
                "3 3\n" +
                "1 2\n" +
                "1 4\n" +
                "4 3\n" +
                "2 3 3\n" +
                "3 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18769.solution();
    }
}