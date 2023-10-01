package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6087Test {
    @Test
    void solution() throws IOException {
        BOJ6087 boj6087 = new BOJ6087();
        String p = "15 10\n" +
                "...*...***.C..*\n" +
                ".*.*.*........*\n" +
                ".*...*...*....*\n" +
                ".*.*....****.**\n" +
                ".*..**........*\n" +
                ".**..********.*\n" +
                ".*...*...*..*.*\n" +
                ".**..***.*.**.*\n" +
                "C........*.....\n" +
                "..***..........\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6087.solution();
    }
}