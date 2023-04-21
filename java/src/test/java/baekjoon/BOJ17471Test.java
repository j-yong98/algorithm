package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17471Test {
    @Test
    void solution() throws IOException {
        BOJ17471 boj17471 = new BOJ17471();
        String p = "6\n" +
                "2 3 4 5 6 7\n" +
                "2 2 3\n" +
                "2 1 3\n" +
                "2 1 2\n" +
                "2 5 6\n" +
                "2 4 6\n" +
                "2 4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17471.solution();
    }

}