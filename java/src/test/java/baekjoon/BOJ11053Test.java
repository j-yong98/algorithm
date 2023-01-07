package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11053Test {

    @Test
    void solution() throws IOException {
        BOJ11053 boj11053 = new BOJ11053();
        String p = "6\n" +
                "10 20 10 30 20 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj11053.solution();
        Assertions.assertThat(solution).isEqualTo(4);
    }

}