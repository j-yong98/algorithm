package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5427Test {
    @Test
    void solution() throws IOException {
        BOJ5427 boj5427 = new BOJ5427();
        String p = "5\n" +
                "4 3\n" +
                "####\n" +
                "#*@.\n" +
                "####\n" +
                "7 6\n" +
                "###.###\n" +
                "#*#.#*#\n" +
                "#.....#\n" +
                "#.....#\n" +
                "#..@..#\n" +
                "#######\n" +
                "7 4\n" +
                "###.###\n" +
                "#....*#\n" +
                "#@....#\n" +
                ".######\n" +
                "5 5\n" +
                ".....\n" +
                ".***.\n" +
                ".*@*.\n" +
                ".***.\n" +
                ".....\n" +
                "3 3\n" +
                "###\n" +
                "#@#\n" +
                "###";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5427.solution();
    }
}