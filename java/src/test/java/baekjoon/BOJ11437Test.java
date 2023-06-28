package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11437Test {
    @Test
    void solution() throws IOException {
        BOJ11437 boj11437 = new BOJ11437();
        String p = "15\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "3 7\n" +
                "6 2\n" +
                "3 8\n" +
                "4 9\n" +
                "2 5\n" +
                "5 11\n" +
                "7 13\n" +
                "10 4\n" +
                "11 15\n" +
                "12 5\n" +
                "14 7\n" +
                "6\n" +
                "6 11\n" +
                "10 9\n" +
                "2 6\n" +
                "7 6\n" +
                "8 13\n" +
                "8 15";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11437.solution();
    }
}