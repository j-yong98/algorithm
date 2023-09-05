package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2792Test {
    @Test
    void solution() throws IOException {
        BOJ2792 boj2792 = new BOJ2792();
        String p = "5 2\n" +
                "7\n" +
                "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2792.solution();
    }

}