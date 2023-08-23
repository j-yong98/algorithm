package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4195Test {
    @Test
    void solution() throws IOException {
        BOJ4195 boj4195 = new BOJ4195();
        String p = "2\n" +
                "3\n" +
                "Fred Barney\n" +
                "Barney Betty\n" +
                "Betty Wilma\n" +
                "3\n" +
                "Fred Barney\n" +
                "Betty Wilma\n" +
                "Barney Betty";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4195.solution();
    }
}