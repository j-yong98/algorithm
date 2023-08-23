package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16719Test {
    @Test
    void solution() throws IOException {
        BOJ16719 boj16719 = new BOJ16719();
        String p = "STARTLINK";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16719.solution();
    }
}