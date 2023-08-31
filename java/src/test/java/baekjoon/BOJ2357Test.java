package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2357Test {
    @Test
    void solution() throws IOException {
        BOJ2357 boj2357 = new BOJ2357();
        String p = "10 4\n" +
                "75\n" +
                "30\n" +
                "100\n" +
                "38\n" +
                "50\n" +
                "51\n" +
                "52\n" +
                "20\n" +
                "81\n" +
                "5\n" +
                "1 10\n" +
                "3 5\n" +
                "6 9\n" +
                "8 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2357.solution();
    }
}