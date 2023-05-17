package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4991Test {
    @Test
    void solution() throws IOException {
        BOJ4991 boj4991 = new BOJ4991();
        String p = "7 5\n" +
                ".......\n" +
                ".o...*.\n" +
                ".......\n" +
                ".*...*.\n" +
                ".......\n" +
                "15 13\n" +
                ".......x.......\n" +
                "...o...x....*..\n" +
                ".......x.......\n" +
                ".......x.......\n" +
                ".......x.......\n" +
                "...............\n" +
                "xxxxx.....xxxxx\n" +
                "...............\n" +
                ".......x.......\n" +
                ".......x.......\n" +
                ".......x.......\n" +
                "..*....x....*..\n" +
                ".......x.......\n" +
                "10 10\n" +
                "..........\n" +
                "..o.......\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                ".....xxxxx\n" +
                ".....x....\n" +
                ".....x.*..\n" +
                ".....x....\n" +
                ".....x....\n" +
                "0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4991.solution();
    }
}