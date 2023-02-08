package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem95Test {

    @Test
    void solution() throws IOException {
        Problem95 problem95 = new Problem95();
        String p = "4 14\n" +
                "5 6\n" +
                "6 5\n" +
                "8 10\n" +
                "5 2\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem95.solution();
        Assertions.assertThat(solution).isEqualTo(13);
    }
}