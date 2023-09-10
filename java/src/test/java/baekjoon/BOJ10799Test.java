package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10799Test {
    @Test
    void solution() throws IOException {
        BOJ10799 boj10799 = new BOJ10799();
        String p = "()(((()())(())()))(())";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10799.solution();
    }
}