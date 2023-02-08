package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem94Test {

    @Test
    void solution() throws IOException {
        Problem94 problem94 = new Problem94();
        String p = "4\n" +
                "2 2 1 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem94.solution();
        Assertions.assertThat(solution).isEqualTo(0);
    }

}