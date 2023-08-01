package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1991Test {
    @Test
    void solution() throws IOException {
        BOJ1991 boj1991 = new BOJ1991();
        String p = "7\n" +
                "A B C\n" +
                "B D .\n" +
                "C E F\n" +
                "E . .\n" +
                "F . G\n" +
                "D . .\n" +
                "G . .";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1991.solution();
    }
}