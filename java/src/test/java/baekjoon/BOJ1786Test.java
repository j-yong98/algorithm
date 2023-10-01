package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1786Test {
    @Test
    void solution() throws IOException {
        BOJ1786 boj1786 = new BOJ1786();
        String p = "ABC ABCDAB ABCDABCDABDE\n" +
                "ABCDABD";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1786.solution();
    }
}