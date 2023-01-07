package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem88Test {

    @Test
    void solution() throws IOException {
        Problem88 problem88 = new Problem88();
        String p = "4 19\n" +
                "4 6 7 9\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem88.solution();
        Assertions.assertThat(solution).isEqualTo(4);
    }

}