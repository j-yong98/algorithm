package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem92Test {

    @Test
    void solution() throws IOException {
        Problem92 problem92 = new Problem92();
        String p = "4 22\n" +
                "7 20\n" +
                "9 26\n" +
                "8 15\n" +
                "4 9\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem92.solution();
        Assertions.assertThat(solution).isEqualTo(61);
    }

}