package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1520Test {

    @Test
    void solution() throws IOException {
        BOJ1520 boj1520 = new BOJ1520();
        String p = "4 5\n" +
                "50 45 37 32 30\n" +
                "35 50 40 20 25\n" +
                "30 30 25 17 28\n" +
                "27 24 22 15 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1520.solution();
    }

}