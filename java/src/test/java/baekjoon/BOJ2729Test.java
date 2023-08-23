package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2729Test {
    @Test
    void solution() throws IOException {
        BOJ2729 boj2729 = new BOJ2729();
        String p = "3\n" +
                "1001101 10010\n" +
                "1001001 11001\n" +
                "1000111 1010110";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2729.solution();
    }
}