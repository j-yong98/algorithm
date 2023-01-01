package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem60Test {

    @Test
    void solution() throws IOException {
        Problem60 problem60 = new Problem60();
        String p = "5 3 \n" +
                "1 2 3 4 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem60.solution();
        Assertions.assertThat(solution).isEqualTo(7);
    }

}