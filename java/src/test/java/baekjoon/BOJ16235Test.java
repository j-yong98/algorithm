package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16235Test {
    @Test
    void solution() throws IOException {
        BOJ16235 boj16235 = new BOJ16235();
        String p = "5 2 6\n" +
                "2 3 2 3 2\n" +
                "2 3 2 3 2\n" +
                "2 3 2 3 2\n" +
                "2 3 2 3 2\n" +
                "2 3 2 3 2\n" +
                "2 1 3\n" +
                "3 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16235.solution();
    }
}