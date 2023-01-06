package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem81Test {

    @Test
    void solution() throws IOException {
        Problem81 problem81 = new Problem81();
        String p = "4 4\n" +
                "1 1 1 1\n" +
                "1 1 1 3\n" +
                "1 4 5 2\n" +
                "1 1 2 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem81.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}