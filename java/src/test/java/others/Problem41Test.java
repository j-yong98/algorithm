package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem41Test {

    @Test
    void init() throws IOException {
        Problem41 problem41 = new Problem41();
        String p = "15";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem41.solution();
        Assertions.assertThat(solution).isEqualTo(4);
    }

}