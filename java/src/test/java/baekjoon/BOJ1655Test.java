package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1655Test {
    @Test
    void solution() throws IOException {
        BOJ1655 boj1655 = new BOJ1655();
        String p = "7\n" +
                "1\n" +
                "5\n" +
                "2\n" +
                "10\n" +
                "-99\n" +
                "7\n" +
                "5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1655.solution();
    }

}