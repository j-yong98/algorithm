package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem69Test {

    @Test
    void solution() throws IOException {
        Problem69 problem69 = new Problem69();
        String p = "9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem69.solution();
        Assertions.assertThat(solution).isEqualTo(55);
    }

}