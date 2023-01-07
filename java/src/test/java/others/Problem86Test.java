package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem86Test {

    @Test
    void solution() throws IOException {
        Problem86 problem86 = new Problem86();
        String p = "5 12\n" +
                "5 2 4 1 6\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem86.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}