package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1065Test {
    @Test
    public void solution() throws IOException {
        BOJ1065 boj1065 = new BOJ1065();
        String p = "210";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj1065.solution();
        Assertions.assertThat(solution).isEqualTo(105);
    }

}