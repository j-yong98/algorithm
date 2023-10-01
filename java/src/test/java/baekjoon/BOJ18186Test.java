package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18186Test {
    @Test
    void solution() throws IOException {
        BOJ18186 boj18186 = new BOJ18186();
        String p = "5 3 2\n" +
                "1 1 1 0 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18186.solution();
    }
}