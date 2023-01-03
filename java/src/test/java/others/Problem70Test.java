package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem70Test {

    @Test
    void solution() throws IOException {
        Problem70 problem70 = new Problem70();
        String p = "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        long solution = problem70.solution();
        Assertions.assertThat(solution).isEqualTo(71);
    }

}