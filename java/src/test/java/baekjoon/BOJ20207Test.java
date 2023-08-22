package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20207Test {
    @Test
    void solution() throws IOException {
        BOJ20207 boj20207 = new BOJ20207();
        String p = "5\n" +
                "1 9\n" +
                "8 9\n" +
                "4 6\n" +
                "3 4\n" +
                "2 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20207.soltuion();
    }

}