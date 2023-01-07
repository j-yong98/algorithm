package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem87Test {

    @Test
    void solution() throws IOException {
        Problem87 problem87 = new Problem87();
        String p = "30";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem87.solution();
        Assertions.assertThat(solution).isEqualTo(4372);
    }
}