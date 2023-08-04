package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16928Test {
    @Test
    void solution() throws IOException {
        BOJ16928 boj16928 = new BOJ16928();
        String p = "3 7\n" +
                "32 62\n" +
                "42 68\n" +
                "12 98\n" +
                "95 13\n" +
                "97 25\n" +
                "93 37\n" +
                "79 27\n" +
                "75 19\n" +
                "49 47\n" +
                "67 17";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16928.solution();
    }
}