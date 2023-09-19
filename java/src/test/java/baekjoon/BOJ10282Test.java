package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10282Test {
    @Test
    void solution() throws IOException {
        BOJ10282 boj10282 = new BOJ10282();
        String p = "2\n" +
                "3 2 2\n" +
                "2 1 5\n" +
                "3 2 5\n" +
                "3 3 1\n" +
                "2 1 2\n" +
                "3 1 8\n" +
                "3 2 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10282.solution();
    }
}