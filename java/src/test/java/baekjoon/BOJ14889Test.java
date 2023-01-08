package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ14889Test {

    @Test
    void solution() throws IOException {
        BOJ14889 boj14889 = new BOJ14889();
        String p = "8\n" +
                "0 5 4 5 4 5 4 5\n" +
                "4 0 5 1 2 3 4 5\n" +
                "9 8 0 1 2 3 1 2\n" +
                "9 9 9 0 9 9 9 9\n" +
                "1 1 1 1 0 1 1 1\n" +
                "8 7 6 5 4 0 3 2\n" +
                "9 1 9 1 9 1 0 9\n" +
                "6 5 4 3 2 1 9 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj14889.solution();
        Assertions.assertThat(solution).isEqualTo(1);
    }

}