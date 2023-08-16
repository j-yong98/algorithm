package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6987Test {
    @Test
    void solution() throws IOException {
        BOJ6987 boj6987 = new BOJ6987();
        String p = "5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4\n" +
                "4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3\n" +
                "5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5\n" +
                "5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6987.solution();
    }
}