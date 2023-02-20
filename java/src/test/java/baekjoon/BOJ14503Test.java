package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ14503Test {
    @Test
    void solution() throws IOException {
        BOJ14503 boj14503 = new BOJ14503();
        String p = "11 10\n" +
                "7 4 0\n" +
                "1 1 1 1 1 1 1 1 1 1\n" +
                "1 0 0 0 0 0 0 0 0 1\n" +
                "1 0 0 0 1 1 1 1 0 1\n" +
                "1 0 0 1 1 0 0 0 0 1\n" +
                "1 0 1 1 0 0 0 0 0 1\n" +
                "1 0 0 0 0 0 0 0 0 1\n" +
                "1 0 0 0 0 0 0 1 0 1\n" +
                "1 0 0 0 0 0 1 1 0 1\n" +
                "1 0 0 0 0 0 1 1 0 1\n" +
                "1 0 0 0 0 0 0 0 0 1\n" +
                "1 1 1 1 1 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj14503.solution();
        Assertions.assertThat(solution).isEqualTo(57);
    }
}