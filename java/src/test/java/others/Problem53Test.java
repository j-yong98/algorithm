package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem53Test {

    @Test
    void solution() throws IOException {
        Problem53 problem53 = new Problem53();
        String p = "6 2 8\n" +
                "1 2 1 3 5 7\n" +
                "2 5 3 1 7 4\n" +
                "3 3 2 7 1 5\n" +
                "6 5 5 8 4 4\n" +
                "7 1 6 2 5 2\n" +
                "5 3 4 5 6 7\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem53.solution();
        Assertions.assertThat(solution).isEqualTo(114);
    }

}