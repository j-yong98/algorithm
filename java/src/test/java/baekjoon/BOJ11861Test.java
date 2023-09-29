package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11861Test {
    @Test
    void solution() throws IOException {
        BOJ11861 boj11861 = new BOJ11861();
        String p = "11\n" +
                "6 5 2 7 8 6 8 3 5 6 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11861.solution();
    }
}