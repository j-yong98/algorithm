package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12852Test {
    @Test
    void solution() throws IOException {
        BOJ12852 boj12852 = new BOJ12852();
        String p = "11";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12852.solution();
    }

}