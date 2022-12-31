package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem55Test {

    @Test
    void solution() throws IOException {
        Problem55 problem55 = new Problem55();
        String p = "6 10 3\n" +
                "5 3 2 2 3 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem55.solution();
        Assertions.assertThat(solution).isEqualTo(2);
    }

}