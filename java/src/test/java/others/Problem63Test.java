package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem63Test {

    @Test
    void solution() throws IOException {
        Problem63 problem63 = new Problem63();
        String p = "3 2\n" +
                "1 1\n" +
                "4 4\n" +
                "3 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem63.solution();
        Assertions.assertThat(solution).isEqualTo(2);
    }

}