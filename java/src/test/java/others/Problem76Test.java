package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem76Test {

    @Test
    void solution() throws IOException {
        Problem76 problem76 = new Problem76();
        String p = "3\n" +
                "1 2 3\n" +
                "6 5 4\n" +
                "7 8 9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem76.solution();
        Assertions.assertThat(solution).isEqualTo(9);
    }

}