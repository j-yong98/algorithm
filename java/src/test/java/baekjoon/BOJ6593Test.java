package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6593Test {
    @Test
    void solution() throws IOException {
        BOJ6593 boj6593 = new BOJ6593();
        String p = "3 4 5\n" +
                "S....\n" +
                ".###.\n" +
                ".##..\n" +
                "###.#\n" +
                "\n" +
                "#####\n" +
                "#####\n" +
                "##.##\n" +
                "##...\n" +
                "\n" +
                "#####\n" +
                "#####\n" +
                "#.###\n" +
                "####E\n" +
                "\n" +
                "1 3 3\n" +
                "S##\n" +
                "#E#\n" +
                "###\n" +
                "\n" +
                "0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6593.solution();
    }
}