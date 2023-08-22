package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1944Test {
    @Test
    void solution() throws IOException {
        BOJ1944 boj1944 = new BOJ1944();
        String p = "5 2\n" +
                "11111\n" +
                "1S001\n" +
                "10001\n" +
                "1K1K1\n" +
                "11111";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1944.solution();
    }
}