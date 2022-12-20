import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {


    @Test
    void solution() throws IOException {
        Problem4 problem4 = new Problem4();
        String p = "3 2\n" +
                "0 1 0\n" +
                "1 0 1\n" +
                "0 0 0\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem4.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }
}