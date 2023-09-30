package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4659Test {
    @Test
    void solution() throws IOException {
        BOJ4659 boj4659 = new BOJ4659();
        String p = "a\n" +
                "tv\n" +
                "ptoui\n" +
                "bontres\n" +
                "zoggax\n" +
                "wiinq\n" +
                "eep\n" +
                "houctuh\n" +
                "end";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4659.solution();
    }
}