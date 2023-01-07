package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1463Test {

    @Test
    void solution() throws IOException {
        BOJ1463 boj1463 = new BOJ1463();
        String p = "10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj1463.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}