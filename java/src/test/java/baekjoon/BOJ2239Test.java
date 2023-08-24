package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2239Test {
    @Test
    void solution() throws IOException {
        BOJ2239 boj2239 = new BOJ2239();
        String p = "103000509\n" +
                "002109400\n" +
                "000704000\n" +
                "300502006\n" +
                "060000050\n" +
                "700803004\n" +
                "000401000\n" +
                "009205800\n" +
                "804000107R";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2239.soltuion();
    }
}