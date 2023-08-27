package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9944Test {
    @Test
    void solution() throws IOException {
        BOJ9944 boj9944 = new BOJ9944();
        String p = "7 7\n" +
                "*******\n" +
                "*******\n" +
                "*******\n" +
                "***.***\n" +
                "*******\n" +
                "*******\n" +
                "*******";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9944.solution();
    }
}