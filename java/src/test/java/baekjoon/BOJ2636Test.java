package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ2636Test {

    @Test
    void solution() throws IOException {
        BOJ2636 boj2636 = new BOJ2636();
        String p = "13 12\n" +
                "0 0 0 0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 1 1 0 0 0\n" +
                "0 1 1 1 0 0 0 1 1 0 0 0\n" +
                "0 1 1 1 1 1 1 0 0 0 0 0\n" +
                "0 1 1 1 1 1 0 1 1 0 0 0\n" +
                "0 1 1 1 1 0 0 1 1 0 0 0\n" +
                "0 0 1 1 0 0 0 1 1 0 0 0\n" +
                "0 0 1 1 1 1 1 1 1 0 0 0\n" +
                "0 0 1 1 1 1 1 1 1 0 0 0\n" +
                "0 0 1 1 1 1 1 1 1 0 0 0\n" +
                "0 0 1 1 1 1 1 1 1 0 0 0\n" +
                "0 0 0 0 0 0 0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj2636.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}