package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem79Test {

    @Test
    void solution() throws IOException {
        Problem79 problem79 = new Problem79();
        String p = "6\n" +
                "9 4 6 7 1 7\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem79.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}