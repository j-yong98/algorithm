package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ8972Test {
    @Test
    void solution() throws IOException {
        BOJ8972 boj8972 = new BOJ8972();
        String p = "12 8\n" +
                "...I....\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "RR......\n" +
                "......RR\n" +
                "R......R\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "...R....\n" +
                "66445394444162";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj8972.solution();
    }
}