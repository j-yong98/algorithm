package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem72Test {

    @Test
    void solution() throws IOException {
        Problem72 problem72 = new Problem72();
        String p = "5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem72.solution();
        Assertions.assertThat(solution).isEqualTo(21);
    }

}