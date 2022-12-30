package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem52Test {

    @Test
    void solution() throws IOException {
        Problem52 problem52 = new Problem52();
        String p = "4 6\n" +
                "1 1\n" +
                "1 3\n" +
                "2 2\n" +
                "2 4\n" +
                "3 3\n" +
                "3 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem52.solution();
        Assertions.assertThat(solution).isEqualTo(4);
    }
}