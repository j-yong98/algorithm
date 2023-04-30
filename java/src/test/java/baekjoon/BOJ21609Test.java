package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21609Test {
    @Test
    void solution() throws IOException {
        BOJ21609 boj21609 = new BOJ21609();
        String p = "4 3\n" +
                "1 1 1 3\n" +
                "3 2 3 3\n" +
                "1 2 -1 3\n" +
                "-1 -1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21609.solution();
    }
}