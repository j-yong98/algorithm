package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem31Test {

    @Test
    void solution() throws IOException {
        Problem31 problem31 = new Problem31();
        String p = "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem31.solution();
        Assertions.assertThat(solution).isEqualTo(8);
    }
}