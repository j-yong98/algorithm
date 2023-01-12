package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ15651Test {
    @Test
    void solution() throws IOException {
        BOJ15651 boj15651 = new BOJ15651();
        String p = "7 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15651.solution();
    }
}