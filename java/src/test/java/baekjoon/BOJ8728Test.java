package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ8728Test {

    @Test
    void solution() throws IOException {
        BOJ8728 boj8728 = new BOJ8728();
        String p = "5\n" +
                "0 1 1 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj8728.solution();
    }

}