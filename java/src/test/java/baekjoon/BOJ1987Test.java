package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1987Test {
    @Test
    void solution() throws IOException {
        BOJ1987 boj1987 = new BOJ1987();
        String p = "2 4\n" +
                "CAAB\n" +
                "ADCB";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1987.solution();
    }
}