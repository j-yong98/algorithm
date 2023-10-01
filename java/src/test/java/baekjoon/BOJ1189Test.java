package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1189Test {
    @Test
    void solution() throws IOException {
        BOJ1189 boj1189 = new BOJ1189();
        String p = "3 4 6\n" +
                "....\n" +
                ".T..\n" +
                "....";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1189.solution();
    }
}