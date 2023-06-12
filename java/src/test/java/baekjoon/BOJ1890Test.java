package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1890Test {
    @Test
    void solution() throws IOException {
        BOJ1890 boj1890 = new BOJ1890();
        String p = "4\n" +
                "1 2 2 3\n" +
                "1 1 3 3\n" +
                "3 1 1 3\n" +
                "3 2 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1890.solution();
    }

}