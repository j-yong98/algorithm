package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16987Test {
    @Test
    void solution() throws IOException {
        BOJ16987 boj16987 = new BOJ16987();
        String p = "8\n" +
                "44 11\n" +
                "116 73\n" +
                "121 54\n" +
                "49 232\n" +
                "69 136\n" +
                "159 242\n" +
                "109 172\n" +
                "28 31";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16987.solution();
    }
}