package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9252Test {
    @Test
    void solution() throws IOException {
        BOJ9252 boj9252 = new BOJ9252();
        String p = "ACAYKP\n" +
                "CAPCAK";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9252.solution();
    }

}