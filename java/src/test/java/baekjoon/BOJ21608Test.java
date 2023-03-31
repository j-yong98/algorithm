package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21608Test {
    @Test
    void solution() throws IOException {
        BOJ21608 boj21608 = new BOJ21608();
        String p = "3\n" +
                "2 6 9 3 4 \n" +
                "9 4 5 1 2\n" +
                "3 9 2 1 4\n" +
                "7 8 1 4 6\n" +
                "5 7 3 9 4\n" +
                "1 7 6 8 3\n" +
                "6 9 3 4 5\n" +
                "4 9 7 5 2\n" +
                "8 1 5 3 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21608.solution();
    }
}