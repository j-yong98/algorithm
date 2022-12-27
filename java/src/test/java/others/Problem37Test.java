package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem37Test {

    @Test
    void solution() throws IOException {
        Problem37 problem37 = new Problem37();
        String p = "5\n" +
                "1 1 1 1 1\n" +
                "1 1 1 1 1\n" +
                "1 1 1 1 1\n" +
                "1 1 1 1 1\n" +
                "1 1 1 1 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem37.solution();

        Assertions.assertThat(solution).isEqualTo(10);
    }

}