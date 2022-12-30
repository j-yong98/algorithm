package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem51Test {

    @Test
    void solution() throws IOException {
        Problem51 problem51 = new Problem51();
        String p = "3\n" +
                "1 2\n" +
                "3 4\n" +
                "5 6\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem51.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}