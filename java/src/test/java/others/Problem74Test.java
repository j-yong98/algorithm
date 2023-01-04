package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem74Test {

    @Test
    void solution() throws IOException {
        Problem74 problem74 = new Problem74();
        String p = "3\n" +
                "2 3 1\n" +
                "5 4 3\n" +
                "1 2 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem74.solution();
        Assertions.assertThat(solution).isEqualTo(11);
    }

}