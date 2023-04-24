package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1911Test {
    @Test
    void solution() throws IOException {
        BOJ1911 boj1911 = new BOJ1911();
        String p = "3 3\n" +
                "1 6\n" +
                "13 17\n" +
                "8 12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1911.solution();
    }
}