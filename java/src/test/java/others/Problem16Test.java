package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import others.Problem16;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem16Test {

    @Test
    void solution() throws IOException {
        Problem16 problem16 = new Problem16();
        String p = "4 2\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem16.solution();
        Assertions.assertThat(solution).isEqualTo(0);

    }
}