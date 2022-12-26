package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem36Test {

    @Test
    void solution() throws IOException {
        Problem36 problem36 = new Problem36();
        String p = "55\n" +
                "31 25 16 33\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem36.solution();

        Assertions.assertThat(solution).isEqualTo(9);
    }
}