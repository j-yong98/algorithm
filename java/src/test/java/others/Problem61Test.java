package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem61Test {

    @Test
    void solution() throws IOException {
        Problem61 problem61 = new Problem61();
        String p = "4\n" +
                "..3.\n" +
                "2..E\n" +
                ".1..\n" +
                "5S.4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem61.solution();
        Assertions.assertThat(solution).isEqualTo(8);
    }

}