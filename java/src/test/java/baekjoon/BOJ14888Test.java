package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ14888Test {

    @Test
    void solution() throws IOException {
        BOJ14888 boj14888 = new BOJ14888();
        String p = "6\n" +
                "1 2 3 4 5 6\n" +
                "2 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14888.solution();
    }

}