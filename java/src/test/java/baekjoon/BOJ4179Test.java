package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4179Test {
    @Test
    void solution() throws IOException {
        BOJ4179 boj4179 = new BOJ4179();
        String p = "5 5\n" +
                "#####\n" +
                "#FJ.#\n" +
                "###.#\n" +
                "###.#\n" +
                "###.#";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4179.solution();
    }

}