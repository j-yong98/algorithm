package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5525Test {
    @Test
    void solution() throws IOException {
        BOJ5525 boj5525 = new BOJ5525();
        String p = "2\n" +
                "13\n" +
                "OOIOIOIOIIOII";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5525.solution();
    }

}