package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13023Test {
    @Test
    void solution() throws IOException {
        BOJ13023 boj13023 = new BOJ13023();
        String p = "8 8\n" +
                "1 7\n" +
                "3 7\n" +
                "4 7\n" +
                "3 4\n" +
                "4 6\n" +
                "3 5\n" +
                "0 4\n" +
                "2 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13023.solution();
    }
}