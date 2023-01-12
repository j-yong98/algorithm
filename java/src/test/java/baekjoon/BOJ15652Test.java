package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15652Test {

    @Test
    void solution() throws IOException {
        BOJ15652 boj15652 = new BOJ15652();
        String p = "3 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15652.solution();
    }

}