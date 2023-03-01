package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Problem101Test {
    @Test
    void solution() throws IOException {
        Problem101 problem101 = new Problem101();
        String p = "5\n" +
                "aAB\n" +
                "bAB\n" +
                "aBA\n" +
                "BaA\n" +
                "BBA\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem101.solution();
        assertThat(solution).isEqualTo(3);
    }
}