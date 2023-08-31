package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15653Test {
    @Test
    void solution() throws IOException {
        BOJ15653 boj15653 = new BOJ15653();
        String p = "10 10\n" +
                "##########\n" +
                "#R#...##B#\n" +
                "#...#.##.#\n" +
                "#####.##.#\n" +
                "#......#.#\n" +
                "#.######.#\n" +
                "#.#...##.#\n" +
                "#.#.#.#..#\n" +
                "#...#.O#.#\n" +
                "##########";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15653.solution();
    }
}