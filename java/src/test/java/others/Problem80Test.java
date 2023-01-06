package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem80Test {

    @Test
    void solution() throws IOException {
        Problem80 problem80 = new Problem80();
        String p = "7\n" +
                "2 0 0 0 1 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem80.solution();
        Assertions.assertThat(solution).isEqualTo(1);
    }

}