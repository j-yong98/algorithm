package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ17142Test {

    @Test
    void solution() throws IOException {
        BOJ17142 boj17142 = new BOJ17142();
        String p = "5 1\n" +
                "2 2 2 1 1\n" +
                "2 1 1 1 1\n" +
                "2 1 1 1 1\n" +
                "2 1 1 1 1\n" +
                "2 2 2 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17142.solution();
    }

}