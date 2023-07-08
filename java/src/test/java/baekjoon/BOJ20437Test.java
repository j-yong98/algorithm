package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20437Test {
    @Test
    void solution() throws IOException {
        BOJ20437 boj20437 = new BOJ20437();
        String p = "2\n" +
                "superaquatornado\n" +
                "2\n" +
                "abcdefghijklmnopqrstuvwxyz\n" +
                "5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20437.solution();
    }
}