package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem93Test {

    @Test
    void solution() throws IOException {
        Problem93 problem93 = new Problem93();
        String p = "5\n" +
                "4 7 8 9 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem93.solution();
        Assertions.assertThat(solution).isEqualTo(1);
    }

}