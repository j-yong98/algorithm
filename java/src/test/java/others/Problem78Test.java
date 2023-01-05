package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem78Test {

    @Test
    void solution() throws IOException {
        Problem78 problem78 = new Problem78();
        String p = "6\n" +
                "1 6 4 3 9 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem78.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}