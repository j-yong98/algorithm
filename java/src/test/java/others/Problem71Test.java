package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem71Test {

    @Test
    void solution() throws IOException {
        Problem71 problem71 = new Problem71();
        String p = "5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem71.solution();
        Assertions.assertThat(solution).isEqualTo(42);
    }

}