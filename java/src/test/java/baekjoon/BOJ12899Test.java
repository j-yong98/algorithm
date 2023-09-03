package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12899Test {
    @Test
    void solution() throws IOException {
        BOJ12899 boj12899 = new BOJ12899();
        String p = "5\n" +
                "1 11\n" +
                "1 29\n" +
                "1 89\n" +
                "2 2\n" +
                "2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12899.solution();
    }
}