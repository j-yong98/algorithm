package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2589Test {
    @Test
    void solution() throws IOException {
        BOJ2589 boj2589 = new BOJ2589();
        String p = "5 7\n" +
                "WLLWWWL\n" +
                "LLLWLLL\n" +
                "LWLWLWW\n" +
                "LWLWLLL\n" +
                "WLLWLWW";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2589.solution();
    }

}