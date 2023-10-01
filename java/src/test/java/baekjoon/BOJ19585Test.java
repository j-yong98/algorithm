package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ19585Test {
    @Test
    void solution() throws IOException {
        BOJ19585 boj19585 = new BOJ19585();
        String p = "3 1\n" +
                "red\n" +
                "re\n" +
                "r\n" +
                "shift\n" +
                "3\n" +
                "redshift\n" +
                "reshift\n" +
                "rshift";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19585.solution();
    }
}