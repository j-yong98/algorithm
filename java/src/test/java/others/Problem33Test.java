package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem33Test {

    @Test
    void solution() throws IOException {
        Problem33 problem33 = new Problem33();
        String p = "5 2 3 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem33.solution();
        Assertions.assertThat(solution).isEqualTo(15);
    }
}