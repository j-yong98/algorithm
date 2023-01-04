package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem73Test {

    @Test
    void solution() throws IOException {
        Problem73 problem73 = new Problem73();
        String p = "3\n" +
                "1 3 2\n" +
                "3 4 5\n" +
                "4 2 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem73.solution();
        Assertions.assertThat(solution).isEqualTo(14);
    }

}