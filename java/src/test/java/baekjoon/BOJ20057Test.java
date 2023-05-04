package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20057Test {
    @Test
    void solution() throws IOException {
        BOJ20057 boj20057 = new BOJ20057();
        String p = "5\n" +
                "100 200 300 400 200\n" +
                "300 243 432 334 555\n" +
                "999 111 0 999 333\n" +
                "888 777 222 333 900\n" +
                "100 200 300 400 500";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20057.solution();
    }
}