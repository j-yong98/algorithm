package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1916Test {
    @Test
    void solution() throws IOException {
        BOJ1916 boj1916 = new BOJ1916();
        String p = "5\n" +
                "8\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "1 4 1\n" +
                "1 5 10\n" +
                "2 4 2\n" +
                "3 4 1\n" +
                "3 5 1\n" +
                "4 5 3\n" +
                "1 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1916.solution();
    }
}