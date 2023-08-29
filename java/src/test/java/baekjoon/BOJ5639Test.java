package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5639Test {
    @Test
    void solution() throws IOException {
        BOJ5639 boj5639 = new BOJ5639();
        String p = "50\n" +
                "30\n" +
                "24\n" +
                "5\n" +
                "28\n" +
                "45\n" +
                "98\n" +
                "52\n" +
                "60";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5639.solution();
    }
}