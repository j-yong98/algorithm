package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1194Test {
    @Test
    void solution() throws IOException {
        BOJ1194 boj1194 = new BOJ1194();
        String p = "7 8\n" +
                "a#c#eF.1\n" +
                ".#.#.#..\n" +
                ".#B#D###\n" +
                "0....F.1\n" +
                "C#E#A###\n" +
                ".#.#.#..\n" +
                "d#f#bF.1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1194.solution();
    }
}