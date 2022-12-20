import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void solution() throws IOException {
        Problem3 problem3 = new Problem3();
        String problem = "4 5\n" +
                "6 5 4 3 1\n" +
                "3 4 4 14 1\n" +
                "6 1 3 15 5\n" +
                "3 5 1 16 3\n";
        System.setIn(new ByteArrayInputStream(problem.getBytes()));

        int solution = problem3.solution();

        Assertions.assertThat(solution).isEqualTo(45);
    }
}