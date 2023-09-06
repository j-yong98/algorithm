package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6218Test {
    @Test
    void solution() throws IOException {
        BOJ6218 boj6218 = new BOJ6218();
        String p = "6 3\n" +
                "1\n" +
                "7\n" +
                "3\n" +
                "4\n" +
                "2\n" +
                "5\n" +
                "1 5\n" +
                "4 6\n" +
                "2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6218.solution();
    }
}