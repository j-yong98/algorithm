package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import others.Problem54;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ15686Test {

    @Test
    void solution() throws IOException {
        BOJ15686 boj15686 = new BOJ15686();
        String p = "5 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj15686.solution();
        Assertions.assertThat(solution).isEqualTo(32);
    }

}