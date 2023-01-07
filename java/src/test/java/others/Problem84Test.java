package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem84Test {

    @Test
    void solution() throws IOException {
        Problem84 problem84 = new Problem84();
        String p = "6\n" +
                "6 5 4 3 4 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem84.solution();
        Assertions.assertThat(solution).isEqualTo(4);
    }

}