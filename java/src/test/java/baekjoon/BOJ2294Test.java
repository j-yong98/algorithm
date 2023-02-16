package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ2294Test {
    @Test
    public void solution() throws IOException {
        BOJ2294 boj2294 = new BOJ2294();
        String p = "3 15\n" +
                "3\n" +
                "4\n" +
                "10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2294.solution();
    }

}