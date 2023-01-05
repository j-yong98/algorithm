package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ9663Test {

    @Test
    void solution() throws IOException {
        BOJ9663 boj9663 = new BOJ9663();
        String p = "8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj9663.solution();
        Assertions.assertThat(solution).isEqualTo(92);
    }

}