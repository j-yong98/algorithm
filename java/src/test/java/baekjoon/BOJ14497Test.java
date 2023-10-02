package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14497Test {
    @Test
    void solution() throws IOException {
        BOJ14497 boj14497 = new BOJ14497();
        String p = "3 3\n" +
                "2 2 1 1\n" +
                "#00\n" +
                "0*0\n" +
                "000";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14497.solution();
    }
}