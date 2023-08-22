package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4396Test {
    @Test
    void solution() throws IOException {
        BOJ4396 boj4396 = new BOJ4396();
        String p = "8\n" +
                "...**..*\n" +
                "......*.\n" +
                "....*...\n" +
                "........\n" +
                "........\n" +
                ".....*..\n" +
                "...**.*.\n" +
                ".....*..\n" +
                "xxx.....\n" +
                "xxxx....\n" +
                "xxxx....\n" +
                "xxxxx...\n" +
                "xxxxx...\n" +
                "xxxxx...\n" +
                "xxx.....\n" +
                "xxxxx...";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4396.solution();
    }
}