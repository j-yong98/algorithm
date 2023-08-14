package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16562Test {
    @Test
    void solution() throws IOException {
        BOJ16562 boj16562 = new BOJ16562();
        String p = "5 3 20\n" +
                "10 10 20 20 30\n" +
                "1 3\n" +
                "2 4\n" +
                "5 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16562.solution();
    }
}