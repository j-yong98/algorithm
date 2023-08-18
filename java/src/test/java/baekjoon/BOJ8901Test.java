package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ8901Test {
    @Test
    void solution() throws IOException {
        BOJ8901 boj8901 = new BOJ8901();
        String p = "2\n" +
                "5 3 7\n" +
                "100 30 80\n" +
                "3 3 3\n" +
                "100 100 100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj8901.solution();
    }
}