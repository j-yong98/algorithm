import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem20Test {

    @Test
    void solution() throws IOException {
        String p = "3\n" +
                "1 2 1\n" +
                "4 5 6\n" +
                "1 8 1\n";
        Problem20 problem20 = new Problem20();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem20.solution();

        Assertions.assertThat(solution).isEqualTo(2);
    }

}